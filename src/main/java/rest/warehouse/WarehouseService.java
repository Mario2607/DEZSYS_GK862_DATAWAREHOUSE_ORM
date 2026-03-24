package rest.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.model.*;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
	
	public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    public WarehouseData getWarehouseData( String inID ) {
        return warehouseRepository.findById(Long.parseLong(inID)).orElse(null);
    }
    
}