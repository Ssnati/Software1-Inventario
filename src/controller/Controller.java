package controller;

import dao.DaoProduct;
import dao.DaoSoldProduct;
import dao.DaoUser;
import model.Product;
import model.Stationery;
import model.User;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener, WindowListener {

    private final ProductList lp;
    private final HVR hv;
    private Ver vr;
    private Vender vnd;
    private Modify md;
    private final CambiarContrasena cambiarContrasena;
    private final Login2 logIn2;
    private User generalUser;
    private Create cr;
    private final Stationery pape;
    private final AddProduct addP;
    private String id_buy;
    private final DaoProduct daoProd;
    private final DaoSoldProduct daoSold;
    private final DaoUser daoUser;
    private final jOptionPane jp;


    public Controller() {
        jp = new jOptionPane();
        daoProd = new DaoProduct();
        daoSold = new DaoSoldProduct();
        daoUser = new DaoUser();
        ArrayList<Product> products = daoProd.consultaProductos();
        ArrayList<Product> soldProducts = daoSold.consultaProductos();
        pape = new Stationery(products, soldProducts);
        generalUser = daoUser.updateUser();
        if (generalUser == null) {
            daoUser.insertDefaultUser();
            generalUser = daoUser.updateUser();
        }
        lp = new ProductList(this, pape.getMatrix(pape.getStockProductList()));
        hv = new HVR(this, pape.getProductsWithinDateMatrix(pape.getProductsWithinDate(LocalDate.now(), LocalDate.now())), "" + pape.calculateUtility(pape.getProductsWithinDate(LocalDate.now(), LocalDate.now())), "" + pape.calculateTotalSold(pape.getProductsWithinDate(LocalDate.now(), LocalDate.now())));
        cambiarContrasena = new CambiarContrasena(this);
        logIn2 = new Login2(this);
        addP = new AddProduct(lp, true, this);
        id_buy = "";
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.init();
    }

    private void init() {
        if (generalUser.isEnableRegister()) {
            cambiarContrasena.setVisible(true);
        } else logIn2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Usuario: " + generalUser.getUsername() + " Contraseña: " + generalUser.getPassword());
        if (e.getActionCommand().contains("_TableSell")) {
            vnd = new Vender(lp, true, this);
            seeSellProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("_confirmSellProduct")) {
            sellProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("cancelSellProduct")) {
            vnd.setVisible(false);
        }
        if (e.getActionCommand().contains("_TableSee")) {
            vr = new Ver(lp, true, this);
            seeProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("cancelSeeModify")) {
            vr.setVisible(false);
        }
        if (e.getActionCommand().contains("_deleteProduct")) {
            deleteProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("_modifyProduct")) {
            md = new Modify(lp, true, this);
            seeModify(e.getActionCommand());
        }
        if (e.getActionCommand().contains("_saveModification")) {
            modifyProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("cancelarModificar")) {
            md.setVisible(false);
        }
        if (e.getActionCommand().contains("logAccept")) {
            addUser();
        }
        if (e.getActionCommand().contains("Ingresar")) {
            checkCredentials();
        }
        if (e.getActionCommand().equals("CancelCreate")) {
            cr.setVisible(false);
        }
        if (e.getActionCommand().equals("CreateProduct")) {
            createProduct();
        }
        if (e.getActionCommand().equals("BuscarProdInvent")) {
            lp.updateTable(this, pape.getProductFiltered(lp.getTextFromTextField()));
        }
        if (e.getActionCommand().contains("_TableBuy")) {
            id_buy = e.getActionCommand().split("_")[0];
            showBuyProduct(e.getActionCommand());
        }
        if (e.getActionCommand().contains("menu_inventario")) {
            if (!lp.isActive()) {
                hv.setVisible(false);
                lp.setVisible(true);
            }
        }
        if (e.getActionCommand().contains("menu_historial")) {
            if (!hv.isActive()) {
                lp.setVisible(false);
                hv.setVisible(true);
            }
        }
        if (e.getActionCommand().contains("menu_crear")) {
            if (hv.isActive()) {
                cr = new Create(hv, true, this);
                cr.setVisible(true);
            } else if (lp.isActive()) {
                cr = new Create(lp, true, this);
                cr.setVisible(true);
            }
        }
        if (e.getActionCommand().contains("cambiar_contrasena")) {
            if (hv.isActive()) {
                cambiarContrasena.setVisible(true);
                hv.setVisible(false);
            } else if (lp.isActive()) {
                cambiarContrasena.setVisible(true);
                lp.setVisible(false);
            }
        }
        if (e.getActionCommand().contains("acept_cambiar_contrasena")) {
            changePassword();
        }
        if (e.getActionCommand().contains("menu_cerrar")) {
            if (hv.isActive()) {
                logIn2.setVisible(true);
                hv.setVisible(false);
            } else if (lp.isActive()) {
                logIn2.setVisible(true);
                lp.setVisible(false);
            }
        }
        if (e.getActionCommand().equals("CloseProgram")) {
            System.exit(0);
        }
        if (e.getActionCommand().contains("buyProduct")) {
            buyProduct(id_buy);
        }
        if (e.getActionCommand().contains("CancelBuy")) {
            addP.setVisible(false);
            addP.setAddProd_txt_cant("");
            addP.setAddProd_txt_Price("");
        }
        if (e.getActionCommand().contains("FiltrarPorFecha")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(hv.getFechaFormatFinString());
                sdf.parse(hv.getFechaIniString());
                new SimpleDateFormat(hv.getFechaFormatFinString());
                sdf.parse(hv.getFechaIniString());
                ArrayList<Product> products = pape.getProductsWithinDate(hv.getFechaIni(), hv.getFechaFin());
                hv.updateTable(this, pape.getProductsWithinDateMatrix(products), "" + pape.calculateUtility(products), "" + pape.calculateTotalSold(products));
            } catch (Exception z) {
                jp.showErrorMessage("Formato de fecha no válido. ");
            }
        }
        System.out.println("ActionCommand: " + e.getActionCommand());
    }

    private void changePassword() {
        String oldPassword = cambiarContrasena.getTxtOldPassword().getText();
        String newPassword = cambiarContrasena.getTextFiel_password().getText();
        String confirmPassword = cambiarContrasena.getTextField_Confirmar().getText();
        if (oldPassword.isBlank() || newPassword.isBlank() || confirmPassword.isBlank()) {
            cambiarContrasena.setLblBtnConfirm("Por favor, complete todos los campos");
        } else {
            if (!oldPassword.equals(generalUser.getPassword())) {
                cambiarContrasena.setLblConfirmacionContra("La contraseña actual es incorrecta");
            } else {
                if (!newPassword.equals(confirmPassword)) {
                    cambiarContrasena.setLblConfirmacionContra("Las contraseñas no coinciden");
                } else {
                    if (newPassword.length() < 5) {
                        cambiarContrasena.setLblConfirmacionContra("La contraseña debe ser minimo de 5 caracteres");
                    } else {
                        generalUser.setPassword(newPassword);
                        daoUser.updateUser(generalUser);
                        jp.showMessage("Contraseña cambiada correctamente\n\nPor favor, vuelva a iniciar sesion.");
                        cambiarContrasena.resetPanel();
                        cambiarContrasena.setVisible(false);
                        logIn2.setVisible(true);
                    }
                }
            }
        }
    }

    private void deleteProduct(String id) {
        Product pd = searchProductStock(id);
        ArrayList<Product> auxList = pape.getStockProductList();
        if (vr.validateWindow("¿Esta seguro de querer eliminar el producto " + pd.getName() + "?\n\nRecuerde que esta accion es irreversible.") == 0) {
            if (executeDelete(pd, auxList)) {
                lp.updateTable(this, pape.getMatrix(pape.getStockProductList()));
                vr.informationMessage("Se ha borrado el producto exitosamente");
                daoProd.eliminarProducto(Integer.parseInt(pd.getId()));
                vr.setVisible(false);
            }
        }
    }

    private boolean executeDelete(Product pd, List<Product> auxList) {
        boolean output = false;
        for (int i = 0; i < auxList.size(); i++)
            if (auxList.get(i).getId().equals(pd.getId())) {
                auxList.remove(i);
                output = true;
            }
        return output;
    }

    private void modifyProduct(String id) {
        Product pd = searchProductStock(id);
        String name = md.getTextFieldNombreModify().getText();
        String brand = md.getTextFieldMarcaModify().getText();
        String quantity = md.getTextFieldCantidadModify().getText();
        String description = md.getTxtDescripcionModify().getText();
        String profit = md.getTextFieldProfit().getText();
        if (name.isBlank() || quantity.isBlank()) {
            md.setLblAvisoModify("Por favor rellene todos los campos marcados con (*)");
        } else {
            md.setLblAvisoModify("");
            if (pd.getSalePrice() == 0) {
                md.setLblAvisoModify("Debes comprar productos para poder modificar la cantidad");
            } else {
                md.setLblAvisoModify("");
                if (Integer.parseInt(profit) < 0) {
                    md.setLblAvisoModify("No se permiten valores negativos en el campo \"Porcentaje de Utilidad\"");
                } else {
                    md.setLblAvisoModify("");
                    if (Integer.parseInt(quantity) < 0) {
                        md.setLblAvisoModify("No se permiten valores negativos en el campo \"Cantidad\"");
                    } else {
                        if ((md.validateWindow("¿Esta seguro de querer guardar los cambios del producto?")) == 0) {
                            pd.setName(name);
                            pd.setBrand(brand);
                            pd.setQuantity(Integer.parseInt(quantity));
                            pd.setDescription(description);
                            pd.setProfitPercentage((profit.equals("")) ? 25 : Integer.parseInt(profit));
                            if (executeModifyProduct(pd)) {
                                md.informationMessage("El producto se ha modificado exitosamente");
                                lp.updateTable(this, pape.getMatrix(pape.getStockProductList()));
                                daoProd.actualizarProduct(pd);
                                md.setVisible(false);
                                vr.setVisible(false);
                            }
                        } else {
                            md.setVisible(false);
                            vr.setVisible(false);
                        }
                    }
                }
            }
        }
    }


    private boolean executeModifyProduct(Product pd) {
        boolean output = false;
        for (Product p : pape.getStockProductList()) {
            if (p.getId().equals(pd.getId())) {
                p.setName(pd.getName());
                p.setBrand(pd.getBrand());
                p.setDescription(pd.getDescription());
                p.setQuantity(pd.getQuantity());
                p.setProfitPercentage(pd.getProfitPercentage());
                output = true;
            }
        }
        return output;
    }

    private void seeModify(String id) {
        Product pd = searchProductStock(id);
        vr.setVisible(false);
        if (pd != null) {
            md.setTextFieldNombreModify(pd.getName());
            md.setTextFieldCodigoModify(pd.getId());
            md.setTextFieldMarcaModify(pd.getBrand());
            md.setTextFieldCantidadModify(String.valueOf(pd.getQuantity()));
            md.setTxtDescripcionModify(pd.getDescription());
            md.setTextFieldProfit(String.valueOf(pd.getProfitPercentage()));
            md.setActionModify();
            md.setVisible(true);
        } else {
            md.errorMessage("No existe el producto");
        }
    }

    private void sellProduct(String id) {
        Product pd = searchProductStock(id);
        try {

            int quantitySpinner = Integer.parseInt(vnd.getSpinnerCantidad().getValue().toString());
            if (pd.getQuantity() < quantitySpinner) {
                vnd.setLblAviso("La cantidad que intentas vender supera la cantidad disponible del producto");
            } else {
                vnd.setLblAviso("");
                if (quantitySpinner == 0) {
                    vnd.setLblAviso("La cantidad que intentas vender debe ser mayor a cero");
                } else {
                    vnd.setLblAviso("");
                    if (vnd.validateWindow("¿Esta seguro de vender " + quantitySpinner + " unidad(es) del producto " + pd.getName() + "?") == 0) {
                        if (executeSell(pd, quantitySpinner)) {
                            vnd.informationMessage("Se vendio " + quantitySpinner + " unidad(es) del producto " + pd.getName() + "   \n\nUnidades restantes: " + pd.getQuantity() + "\n\n");
                            vnd.resetWindow();
                            lp.updateTable(this, pape.getMatrix(pape.getStockProductList()));
                            ArrayList<Product> products = pape.getProductsWithinDate(hv.getFechaIni(), hv.getFechaFin());
                            hv.updateTable(this, pape.getProductsWithinDateMatrix(products), "" + pape.calculateUtility(products), "" + pape.calculateTotalSold(products));
                            vnd.setVisible(false);
                        }
                    }
                }
            }
        } catch (NumberFormatException excepcion) {
            jp.showErrorMessage("Los datos ingresados no son validos");
        }
    }

    private boolean executeSell(Product pd, int quantity) {
        boolean output = false;
        for (Product p : pape.getStockProductList()) {
            if (p.getId().equals(pd.getId())) {
                p.setQuantity(p.getQuantity() - quantity);
                p.setSaleDate(LocalDate.now());
                pape.addSoldProduct(new Product(p.getId(), p.getName(), p.getProfitPercentage(), p.getBrand(), p.getDescription(), quantity, p.getSaleDate(), p.getSalePrice(), p.getPurchasePrice()));
                output = true;
                daoProd.actualizarSellProduct(p.getId(), p.getQuantity(), p.getSaleDate().toString());
                daoSold.insertProduct(p, quantity);
            }
        }
        return output;
    }

    private void seeSellProduct(String id) {
        Product pd = searchProductStock(id);
        if (pd == null) {
            vnd.errorMessage("No existe el producto");
        } else {
            if (pd.getQuantity() == 0) {
                vnd.warningMessage("No hay unidades disponibles.");
            } else {
                vnd.setTextFieldCodigo(pd.getId());
                vnd.setTextFieldNombre(pd.getName());
                vnd.setTextFieldProfit(String.valueOf(pd.getProfitPercentage()));
                vnd.setTextFieldCantidadEnStock(String.valueOf(pd.getQuantity()));
                vnd.setTextFieldMarca(pd.getBrand());
                vnd.setTxtDescripcion(pd.getDescription());
                vnd.setTextFieldPrecioVenta(String.valueOf(pd.getSalePrice()));
                vnd.setActionSell();
                vnd.setVisible(true);
            }
        }
    }

    private Product searchProductStock(String id) {
        String idProduct = id.split("_")[0];
        Product myProduct = null;
        ArrayList<Product> products = pape.getStockProductList();
        for (Product pd : products)
            if (pd.getId().equals(idProduct)) myProduct = pd;
        return myProduct;
    }

    private void seeProduct(String id) {
        Product myPd = searchProductStock(id);
        if (myPd != null) {
            vr.setTextFieldNombreVer(myPd.getName());
            vr.setTextFieldCodigoVer(myPd.getId());
            vr.setTextFieldMarcaVer(myPd.getBrand());
            vr.setTextFieldCantidadVer(String.valueOf(myPd.getQuantity()));
            vr.setTextFieldProfit(String.valueOf(myPd.getProfitPercentage()));
            vr.setTextFieldSalePrice(String.valueOf(myPd.getSalePrice()));
            vr.setTxtDescripcionVer(myPd.getDescription());
            vr.setActionSee();
            vr.setVisible(true);
        } else {
            vr.errorMessage("No existe el producto");
        }
    }


    private void buyProduct(String id) {
        Product pd = searchProductStock(id);
        String cantidad = addP.getAddProd_txt_cant().getText();
        String precio = addP.getAddProd_txt_Price().getText();
        int percentage = pd.getProfitPercentage();
        try {
            if (cantidad.isBlank() || precio.isBlank()) {
                jp.showErrorMessage("Por favor, complete todos los campos.");
            } else if (Integer.parseInt(precio) > 900000000 || Integer.parseInt(cantidad) > 900000000) {
                jp.showErrorMessage("Los valores ingresados son demasiado altos.");
            } else if (!isDoublePositive(precio)) {
                jp.showErrorMessage("Precio debe ser un valor numerico mayor a cero.");
            } else if (isPositiveInteger(cantidad)) {
                jp.showErrorMessage("Cantidad debe ser un numero entero positivo.");
            } else {
                double p = Integer.parseInt(precio) / Integer.parseInt(cantidad);
                pape.buyProd(id, cantidad, "" + (Integer.parseInt(precio) / Integer.parseInt(cantidad)), precio, percentage);
                addP.setVisible(true);
                addP.setAddProd_txt_cant("");
                addP.setAddProd_txt_Price("");
                addP.setTextFieldCantidad("" + pd.getQuantity());
                lp.updateTable(this, pape.getMatrix(pape.getStockProductList()));

                daoProd.actualizarBuyProduct(id, Integer.parseInt(cantidad), p + (p * percentage / 100));
                jp.showMessage("Compra registrada.");
                addP.setVisible(false);
            }
        } catch (NumberFormatException exception) {
            jp.showErrorMessage("Los valores ingresados no son validos.");
        }
    }

    private void showBuyProduct(String id) {
        Product pd = searchProductStock(id);
        addP.setTextFieldCodigo(pd.getId());
        addP.setTextFieldNombre(pd.getName());
        addP.setTextFieldCantidad(String.valueOf(pd.getQuantity()));
        addP.setTextFieldMarca(pd.getBrand());
        addP.setTxtDescripcion(pd.getDescription());
        addP.setVisible(true);
    }

    private void createProduct() {
        String codigo = cr.getTextFieldCod().getText();
        String name = cr.getTextFieldNom().getText();
        String profitPercentage = cr.getTextFieldUtil().getText();
        String brand = cr.getTextFieldMarca().getText();
        String description = cr.getTxtrADesc().getText();

        if (!isValidProduct(codigo, name, profitPercentage)) {
            return;
        }

        codigo = generateProductCode(codigo);
        profitPercentage = profitPercentage.isBlank() ? "25" : profitPercentage;

        Product product = new Product(codigo, name, Integer.parseInt(profitPercentage), brand, description, 0, LocalDate.of(2000, 1, 1), 0.0, 0.0);
        addProductToList(product);
    }

    private boolean isValidProduct(String codigo, String name, String profitPercentage) {
        if (name.isBlank()) {
            jp.showErrorMessage("Por favor rellene todos los campos marcados con (*)");
            return false;
        } else if (!codigo.isBlank() && isPositiveInteger(codigo)) {
            jp.showErrorMessage("El codigo debe ser un entero positivo");
            return false;
        } else if (!profitPercentage.isBlank() && isPositiveInteger(profitPercentage)) {
            jp.showErrorMessage("El porcentaje de utilidad debe ser un entero Positivo");
            return false;
        } else if (pape.searchProduct(codigo) != -1) {
            jp.showErrorMessage("Este codigo ya se encuentra registrado");
            return false;
        }
        return true;
    }

    private String generateProductCode(String codigo) {
        if (codigo.isBlank()) {
            int i = 1;
            while (pape.searchProduct("" + i) != -1) {
                i++;
            }
            codigo = "" + i;
        }
        return codigo;
    }

    private void addProductToList(Product product) {
        pape.getStockProductList().add(product);
        lp.updateTable(this, pape.getMatrix(pape.getStockProductList()));
        cr.setVisible(false);

        daoProd.insertProduct(product);
        jp.showMessage("El producto " + product.getName() + ", con codigo " + product.getId() + " fue creado correctamente.");
    }

    public boolean isPositiveInteger(String cadena) {
        try {
            return Integer.parseInt(cadena) <= 0;
        } catch (NumberFormatException ignored) {
            return true;
        }
    }

    public boolean isDoublePositive(String cadena) {
        try {
            return Double.parseDouble(cadena) > 0;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    private void checkCredentials() {
        if (logIn2.getTextFieldUser().getText().equals(generalUser.getUsername()) && logIn2.getTextFieldPassword().getText().equals(generalUser.getPassword())) {
            lp.setVisible(true);
            logIn2.setVisible(false);
            logIn2.resetPanel();
        } else if (!logIn2.getTextFieldUser().getText().equals(generalUser.getUsername())) {
            logIn2.setLblAvisoPassword("El usuario ingresado es incorrecto");
        } else if (!logIn2.getTextFieldPassword().getText().equals(generalUser.getPassword())) {
            logIn2.setLblAvisoPassword("La contraseña ingresada es incorrecta");
        }
    }

    private void addUser() {
        String username = cambiarContrasena.getTxtOldPassword().getText();
        String password = cambiarContrasena.getTextFiel_password().getText();
        String confPass = cambiarContrasena.getTextField_Confirmar().getText();

        if (username.isBlank() || password.isBlank() || confPass.isBlank()) {
            cambiarContrasena.setLblBtnConfirm("Por favor, complete todos los campos");
        } else {
            cambiarContrasena.setLblBtnConfirm("");
            if (!password.equals(confPass)) {
                cambiarContrasena.setLblConfirmacionContra("Las contraseñas no coinciden");
            } else {
                if (password.length() < 5) {
                    cambiarContrasena.setLblConfirmacionContra("La contraseña debe ser minimo de 5 caracteres");
                } else {
                    generalUser.setEnableRegister(false);
                    generalUser.setUsername(username);
                    generalUser.setPassword(password);
                    cambiarContrasena.resetPanel();
                    daoUser.updateUser(generalUser);
                    cambiarContrasena.setVisible(false);
                    logIn2.setVisible(true);
                }
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }
}