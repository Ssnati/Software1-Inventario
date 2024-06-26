package model;

import java.time.LocalDate;

public class Product {
	private String id;
	private String name;
	private double profitPercentage;
	private String brand;
	private String description;
	private int quantity;
	private LocalDate saleDate;
	private double salePrice;
	private double purchasePrice;
	private int rangoStock;
	
	public Product(String id, String name,double profitPercentage, String brand, String description,int quantity, LocalDate saleDate,
			double salePrice, double purchasePrice, int rangoStock) {
		this.id = id;
		this.name = name;
		this.profitPercentage = profitPercentage;
		this.brand = brand;
		this.description = description;
		this.quantity = quantity;
		this.saleDate = saleDate;
		this.salePrice = salePrice;
		this.purchasePrice = purchasePrice;
		this.rangoStock = rangoStock;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProfitPercentage() {
		return profitPercentage;
	}
	public void setProfitPercentage(double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salesPrice) {
		this.salePrice = salesPrice;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getRangoStock() {
		return rangoStock;
	}

	public void setRangoStock(int rangoStock) {
		this.rangoStock = rangoStock;
	}
	@Override
	public String toString() {
		return "Producto [Código=" + id + ", Nombre=" + name + ", Cantidad=" + quantity + ", Marca=" + brand
				+ ", Porcentaje de Utilidad=" + profitPercentage + ", Precio de Venta=" + salePrice 
				+ ", Descripcion=" + description + "Rango de stock= "+rangoStock + "]";
	}

}
