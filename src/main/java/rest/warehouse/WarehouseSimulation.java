package rest.warehouse;

import rest.model.*;
import java.util.*;

public class WarehouseSimulation {
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
	
	public WarehouseData getData( String inID ) {
		
		WarehouseData data = new WarehouseData();
        data.setWarehouseID( inID );
        if(inID.equals( "001" ) ) {
            data.setWarehouseName( "Linz Bahnhof" );
            data.setWarehouseAddress( "Bahnhofpl. 3-6" );
            data.setWarehouseCity( "Linz" );
            data.setWarehouseCountry( "Österreich" );
            data.setWarehousePostalCode( 4020 );
        }else if(inID.equals( "002" ) ) {
            data.setWarehouseName( "Wien Hauptbahnhof" );
            data.setWarehouseAddress( "Am Hbf 1" );
            data.setWarehouseCity( "Wien" );
            data.setWarehouseCountry( "Österreich" );
            data.setWarehousePostalCode( 1100 );
        }

        List<ProductData> productData = new ArrayList<>();
        productData.add(new ProductData("00-443175", "Bio Orangensaft Sonne", "Getraenk", getRandomInt(0, 2500), "Packung 1L"));
        productData.add(new ProductData("00-871895","Bio Apfelsaft Gold","Getraenk",getRandomInt(0, 2500),"Packung 1L"));
        productData.add(new ProductData("01-926885","Ariel Waschmittel Color","Waschmittel",getRandomInt(0, 2500),"Packung 3KG"));
        productData.add(new ProductData("00-316253","Persil Discs Color","Waschmittel",getRandomInt(0, 2500),"Packung 700G"));
        productData.add(new ProductData("02-341867","Milka Tafel","Sueßigkeit",getRandomInt(0, 2500),"Packung 500G"));

        int randomZahl = getRandomInt(2, 4);
        List<ProductData> produkte = new ArrayList<>();
        for (int i = 0; i < randomZahl; i++) {
            produkte.add(productData.get(i));
        }
        data.setProductData(produkte);
        return data;
		
	}

}
