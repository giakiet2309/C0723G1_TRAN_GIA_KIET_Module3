package model;

public class ProductDTO {
    private int productId;
    private String productCode;
    private String productName;
    private String unit;
    private int price;
    private String productType;
    private String harvestDate;

    public ProductDTO(int productId, String productCode, String productName, String unit, int price, String productType, String harvestDate) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.productType = productType;
        this.harvestDate = harvestDate;
    }

    public ProductDTO() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }
}
