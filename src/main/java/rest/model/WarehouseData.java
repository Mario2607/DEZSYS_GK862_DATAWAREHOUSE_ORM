package rest.model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class WarehouseData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String warehouseID;
	private String warehouseName;
    private String warehouseAddress;
    private int warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
	private String timestamp;

	@JsonManagedReference
	@OneToMany(mappedBy = "warehouseData", cascade = CascadeType.ALL)
    private List<ProductData> productData;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}
	
	/**
	 * Setter and Getter Methods
	 */
	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public void setWarehousePostalCode(int warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

    public List<ProductData> getProductData() {
        return productData;
    }

	public void setProductData(List<ProductData> productData) {
		this.productData = productData;
	}

    /**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
