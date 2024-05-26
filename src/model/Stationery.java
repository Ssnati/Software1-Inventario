package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Stationery {
	private ArrayList<Product> stockProductList;
	private ArrayList<Product> soldProductList;

	public Stationery() {
		stockProductList = null;
	}

	public Stationery(ArrayList<Product> productList, ArrayList<Product> soldProductList) {
		this.stockProductList = productList;
		this.soldProductList = soldProductList;
	}
	
	public void buyProd(String id, String cant, String Unitprice, String pricePortodo, double percentage) {
		int pos = searchProduct(id);
		Product newProd =  stockProductList.get(pos);
		newProd.setQuantity(newProd.getQuantity()+Integer.parseInt(cant));
		newProd.setSalePrice(Double.parseDouble(Unitprice)+(Double.parseDouble(Unitprice)*percentage/100));
		newProd.setPurchasePrice(Double.parseDouble(pricePortodo)/Double.parseDouble(cant));
		stockProductList.set(pos, newProd);
	}
	
	public int searchProduct(String id) {
		int pos = -1;
		for(int i = 0; i < stockProductList.size(); i++)
			if(stockProductList.get(i).getId().equals(id))
				pos = i;
		return pos;
	}
	
	public String[][] getProductsWithinDateMatrix(ArrayList<Product> products) {
		return getMatrix(products);
	}
	
	public ArrayList<Product> getProductsWithinDate(LocalDate ini, LocalDate fin) {
		ArrayList<Product> products = new ArrayList<Product>();
		if(ini.isBefore(fin) || ini.isEqual(fin)) {
			for (Product product : soldProductList) {
				if ((product.getSaleDate().isAfter(ini) && product.getSaleDate().isBefore(fin)) || (product.getSaleDate().isEqual(ini) || product.getSaleDate().isEqual(fin))) {
		            products.add(product);
		        }
			}
		}return products;
	}
	
	public String calculateUtility(ArrayList<Product> products) {
		DecimalFormat formato = new DecimalFormat("###,###,###,###.##");
		double utility = 0;
		double percentage = 0;
		for (Product product : products) {
			percentage = ((double)(product.getProfitPercentage())/100);
			utility += product.getPurchasePrice()*percentage*product.getQuantity();
		}return formato.format(utility);
	}
	
	public String calculateTotalSold(ArrayList<Product> products) {
		DecimalFormat formato = new DecimalFormat("###,###,###,###.##");
		double totalSold = 0;
		for (Product product : products) {
			totalSold += product.getSalePrice()*product.getQuantity();
		}return formato.format(totalSold);
	}
	//Retorna la lista de productos cuyo nombre, marca o descripcion coinciden con la palabra clave ingresada en la ventana ProductList
	public String[][] getProductFiltered(String keyWord){
		ArrayList<Product> aux = new ArrayList<Product>();
		Product temp = null;
		for (int i = 0; i < stockProductList.size(); i++) {
			temp = stockProductList.get(i);
			if(temp.getId().toUpperCase().contains(keyWord.toUpperCase()) || temp.getName().toUpperCase().contains(keyWord.toUpperCase()) || temp.getBrand().toUpperCase().contains(keyWord.toUpperCase()) || temp.getDescription().toUpperCase().contains(keyWord.toUpperCase())) {
				aux.add(temp);
			}
		}return getMatrix(aux);
	}

	public String[][] getStockFiltered(){
		ArrayList<Product> aux = new ArrayList<Product>();
		Product temp = null;
		for (int i = 0; i < stockProductList.size(); i++) {
			temp = stockProductList.get(i);
			if(temp.getQuantity() <= temp.getRangoStock()) {
				aux.add(temp);
			}
		}return getMatrix(aux);
	}
	public String[][] getTodos(){
		ArrayList<Product> aux = new ArrayList<Product>();
		Product temp = null;
		for (int i = 0; i < stockProductList.size(); i++) {
			temp = stockProductList.get(i);
				aux.add(temp);
		}return getMatrix(aux);
	}

	public void addSoldProduct(Product p) {
		soldProductList.add(p);
	}
	public ArrayList<Product> getStockProductList() {
		return stockProductList;
	}
	
	public void setStockProductList(ArrayList<Product> stockProductList) {
		this.stockProductList = stockProductList;
	}
	public ArrayList<Product> getSoldProductList() {
		return soldProductList;
	}
	public void setSoldProductList(ArrayList<Product> soldProductList) {
		this.soldProductList = soldProductList;
	}
	@Override
	public String toString() {
		return "Inventary [Lista de Productos en Stock=" + stockProductList.toString() + ", Lista de Productos Vendidos=" + soldProductList.toString() + "]";
	}


	public String[][] getMatrix(ArrayList<Product> products) {
		// Ordenar la lista de productos por ID numérico
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				int id1 = Integer.parseInt(p1.getId());
				int id2 = Integer.parseInt(p2.getId());
				return Integer.compare(id1, id2);
			}
		});

		DecimalFormat formato = new DecimalFormat("###,###,###,###.##");
		String[][] matrix = new String[products.size()][10];
		Product temp;

		for (int i = 0; i < products.size(); i++) {
			temp = products.get(i);
			matrix[i][0] = temp.getId();
			matrix[i][1] = temp.getName();
			matrix[i][2] = "" + temp.getProfitPercentage();
			matrix[i][3] = temp.getBrand();
			matrix[i][4] = temp.getDescription();
			matrix[i][5] = "" + temp.getQuantity();
			matrix[i][6] = temp.getSaleDate().toString();
			matrix[i][7] = " $" + formato.format(temp.getSalePrice());
			matrix[i][8] = " $" + formato.format(temp.getPurchasePrice());
			matrix[i][9] = "" + temp.getRangoStock();
		}

		return matrix;
	}
}
