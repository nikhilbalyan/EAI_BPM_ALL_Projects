
package apache_cxf.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.16
 * Fri Dec 15 01:35:50 IST 2017
 * Generated source version: 3.0.16
 */

@XmlRootElement(name = "getUrName", namespace = "http://apache_cxf/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUrName", namespace = "http://apache_cxf/")

public class GetUrName {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

