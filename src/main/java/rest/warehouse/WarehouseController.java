package rest.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import rest.model.*;

@RestController
@RequestMapping("/api")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;
	
    @RequestMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/json'>Link to JSON warehouse/001/json</a><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/xml'>Link to XML warehouse/001/xml</a><br/>" +
                          "<a href='http://localhost:8080/index.html'>Link to warehouseTable</a><br/>";
        return mainPage;
    }

    @RequestMapping(value="/warehouse/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseData( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

    @RequestMapping(value="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXML( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

    @PostMapping("/warehouse/add/{warehouseId}")
    public String addWarehouse(@PathVariable String warehouseId) {

        WarehouseData data = new WarehouseData();
        data.setWarehouseID(warehouseId);

        if(warehouseId.equals("001")){
            data.setWarehouseName("Linz Bahnhof");
            data.setWarehouseAddress("Bahnhofpl. 3-6");
            data.setWarehouseCity("Linz");
            data.setWarehouseCountry("Österreich");
            data.setWarehousePostalCode(4020);
        } else {
            data.setWarehouseName("Wien Hauptbahnhof");
            data.setWarehouseAddress("Am Hbf 1");
            data.setWarehouseCity("Wien");
            data.setWarehouseCountry("Österreich");
            data.setWarehousePostalCode(1100);
        }

        warehouseRepository.save(data);
        return "Warehouse added!";
    }

    @PostMapping("/product/add/{warehouseId}/{productId}")
    public String addProduct(@PathVariable String warehouseId, @PathVariable String productId){
        WarehouseData data = warehouseRepository.findByWarehouseID(warehouseId).orElse(null);
        ProductData productData;
        switch (productId) {
            case "00-443175":
                productData = new ProductData("00-443175", "Bio Orangensaft Sonne", "Getraenk", 100, "Packung 1L");
                break;
            case "00-871895":
                productData = new ProductData("00-871895", "Bio Apfelsaft Gold", "Getraenk", 120, "Packung 1L");
                break;
            case "01-926885":
                productData = new ProductData("01-926885", "Ariel Waschmittel Color", "Waschmittel", 80, "Packung 3KG");
                break;
            case "00-316253":
                productData = new ProductData("00-316253", "Persil Discs Color", "Waschmittel", 60, "Packung 700G");
                break;
            case "02-341867":
                productData = new ProductData("02-341867", "Milka Tafel", "Sueßigkeit", 200, "Packung 500G");
                break;
            default:
                return null;
        }
        productData.setWarehouseData(data);
        productRepository.save(productData);
        return "Product added!";
    }

    @GetMapping(value="/warehouse/all", produces="application/json")
    public Iterable<WarehouseData> getAllWarehouses(){
        return warehouseRepository.findAll();
    }

    @GetMapping(value = "/warehouse/{id}", produces="application/json")
    public WarehouseData getWarehouse(@PathVariable String id){
        return warehouseRepository.findByWarehouseID(id).orElse(null);
    }

    @GetMapping(value="/product/all", produces="application/json")
    public Iterable<ProductData> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping(value="/product/{warehouseID}/{productID}", produces="application/json")
    public ProductData getProduct(@PathVariable String warehouseID, @PathVariable String productID){
        return productRepository.findByWarehouseData_WarehouseIDAndProductID(warehouseID, productID).orElse(null);
    }

    @DeleteMapping("/warehouse/delete/{id}")
    public String deleteWarehouse(@PathVariable String id){
        WarehouseData data = warehouseRepository.findByWarehouseID(id).orElse(null);
        warehouseRepository.delete(data);
        return "Warehouse and its products deleted!";
    }

    @DeleteMapping("/product/delete/{warehouseID}/{productID}")
    public String deleteProduct(@PathVariable String warehouseID, @PathVariable String productID){
        ProductData product = productRepository.findByWarehouseData_WarehouseIDAndProductID(warehouseID, productID).orElse(null);
        productRepository.delete(product);
        return "Product deleted!";
    }

    @PutMapping("/warehouse/update/{warehouseID}")
    public String updateWarehouse(@PathVariable String warehouseID){
        WarehouseData data = warehouseRepository.findByWarehouseID(warehouseID).orElse(null);
        data.setWarehouseName("UPDATED NAME");
        data.setWarehouseCity("UPDATED CITY");
        warehouseRepository.save(data);
        return "Warehouse updated!";
    }
}