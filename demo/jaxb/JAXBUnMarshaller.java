package demo.jaxb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

// import java content classes generated by binding compiler
import generated.*;

public class JAXBUnMarshaller {
	public void unMarshal(String xmlFile) {
		try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "generated" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            /*JAXBElement<?> hfElem = 
            		(JAXBElement<?>)u.unmarshal( new FileInputStream( xmlFile ) );*/
            HostedFunction hf = 
            		(HostedFunction)u.unmarshal( new FileInputStream( xmlFile ) );
            //HostedFunction hf = (HostedFunction)hfElem.getValue();
            System.out.println("Hosted Function name: " + hf.getName());
            System.out.println("Hosted Function guid: " + hf.getGuid());
            
            List hfSamplingPorts = hf.getHFSamplingPort();
            displayHFSamplingPorts(hfSamplingPorts);
            
            List hfQueuingPorts = hf.getHFQueuingPort();
            displayHFQueuingPorts(hfQueuingPorts);
                
            /*
            // examine some of the content in the PurchaseOrder
            System.out.println( "Ship the following items to: " );
            
            // display the shipping address
            USAddress address = po.getShipTo();
            displayAddress( address );
            
            // display the items
            Items items = po.getItems();
            displayItems( items );
            */
            
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch( IOException ioe ) {
            ioe.printStackTrace();
        }
	}
	
	private static void displayHFSamplingPorts( List hfsp ) {
		System.out.println( "displayHFSamplingPorts(): Size of sampling ports = "
				+ hfsp.size());
		/*
        // the items object contains a List of primer.po.ItemType objects
        List itemTypeList = items.getItem();

                
        // iterate over List
        for( Iterator iter = itemTypeList.iterator(); iter.hasNext(); ) {
            Items.Item item = (Items.Item)iter.next(); 
            System.out.println( "\t" + item.getQuantity() +
                                " copies of \"" + item.getProductName() +
                                "\"" ); 
        }*/
    }
	
	private static void displayHFQueuingPorts( List hfqp ) {
		System.out.println( "displayHFSamplingPorts(): Size of queuing ports = "
				+ hfqp.size());
		/*
        // the items object contains a List of primer.po.ItemType objects
        List itemTypeList = items.getItem();

                
        // iterate over List
        for( Iterator iter = itemTypeList.iterator(); iter.hasNext(); ) {
            Items.Item item = (Items.Item)iter.next(); 
            System.out.println( "\t" + item.getQuantity() +
                                " copies of \"" + item.getProductName() +
                                "\"" ); 
        }*/
    }

}
