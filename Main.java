import java.io.File;

import demo.jaxb.*;

public class Main {

	public static void main(String[] args) {
		JAXBUnMarshaller jaxbUnmarshaller = new JAXBUnMarshaller();
		jaxbUnmarshaller.unMarshal("xml/HF_IDU2.xml");
		
	}

}
