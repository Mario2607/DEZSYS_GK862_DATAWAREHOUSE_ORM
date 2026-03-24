package rest.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseData warehouseData;

    public ProductData() {}
    public ProductData(String productID, String productName, String productCategory, int productQuantity, String productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public WarehouseData getWarehouseData() {
        return warehouseData;
    }

    public void setWarehouseData(WarehouseData warehouseData) {
        this.warehouseData = warehouseData;
    }
}
