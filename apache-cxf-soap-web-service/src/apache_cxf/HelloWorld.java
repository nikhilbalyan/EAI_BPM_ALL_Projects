package apache_cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://apache_cxf/", portName = "HelloWorldPort", serviceName = "HelloWorldService")
public class HelloWorld {

	public String getUrName(@WebParam(name = "arg0") String name) {
		return "hello MR." + name + "welcome to web service";
	}
}
