package model;

public class ProductType {
    private int idProductType;
    private String productName;

    public ProductType(int idProductType, String productName) {
        this.idProductType = idProductType;
        this.productName = productName;
    }

    public ProductType() {
    }

    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
