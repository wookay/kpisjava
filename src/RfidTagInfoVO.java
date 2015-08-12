/**
 * RfidTagInfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package webservice.MedicinesInfoWS;

public class RfidTagInfoVO  implements java.io.Serializable {
    private java.lang.String s_field1;

    private java.lang.String s_field2;

    private java.lang.String s_field3;

    private java.lang.String s_field4;

    private java.lang.String s_field5;

    public RfidTagInfoVO() {
    }

    public RfidTagInfoVO(
           java.lang.String s_field1,
           java.lang.String s_field2,
           java.lang.String s_field3,
           java.lang.String s_field4,
           java.lang.String s_field5) {
           this.s_field1 = s_field1;
           this.s_field2 = s_field2;
           this.s_field3 = s_field3;
           this.s_field4 = s_field4;
           this.s_field5 = s_field5;
    }


    /**
     * Gets the s_field1 value for this RfidTagInfoVO.
     * 
     * @return s_field1
     */
    public java.lang.String getS_field1() {
        return s_field1;
    }


    /**
     * Sets the s_field1 value for this RfidTagInfoVO.
     * 
     * @param s_field1
     */
    public void setS_field1(java.lang.String s_field1) {
        this.s_field1 = s_field1;
    }


    /**
     * Gets the s_field2 value for this RfidTagInfoVO.
     * 
     * @return s_field2
     */
    public java.lang.String getS_field2() {
        return s_field2;
    }


    /**
     * Sets the s_field2 value for this RfidTagInfoVO.
     * 
     * @param s_field2
     */
    public void setS_field2(java.lang.String s_field2) {
        this.s_field2 = s_field2;
    }


    /**
     * Gets the s_field3 value for this RfidTagInfoVO.
     * 
     * @return s_field3
     */
    public java.lang.String getS_field3() {
        return s_field3;
    }


    /**
     * Sets the s_field3 value for this RfidTagInfoVO.
     * 
     * @param s_field3
     */
    public void setS_field3(java.lang.String s_field3) {
        this.s_field3 = s_field3;
    }


    /**
     * Gets the s_field4 value for this RfidTagInfoVO.
     * 
     * @return s_field4
     */
    public java.lang.String getS_field4() {
        return s_field4;
    }


    /**
     * Sets the s_field4 value for this RfidTagInfoVO.
     * 
     * @param s_field4
     */
    public void setS_field4(java.lang.String s_field4) {
        this.s_field4 = s_field4;
    }


    /**
     * Gets the s_field5 value for this RfidTagInfoVO.
     * 
     * @return s_field5
     */
    public java.lang.String getS_field5() {
        return s_field5;
    }


    /**
     * Sets the s_field5 value for this RfidTagInfoVO.
     * 
     * @param s_field5
     */
    public void setS_field5(java.lang.String s_field5) {
        this.s_field5 = s_field5;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RfidTagInfoVO)) return false;
        RfidTagInfoVO other = (RfidTagInfoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.s_field1==null && other.getS_field1()==null) || 
             (this.s_field1!=null &&
              this.s_field1.equals(other.getS_field1()))) &&
            ((this.s_field2==null && other.getS_field2()==null) || 
             (this.s_field2!=null &&
              this.s_field2.equals(other.getS_field2()))) &&
            ((this.s_field3==null && other.getS_field3()==null) || 
             (this.s_field3!=null &&
              this.s_field3.equals(other.getS_field3()))) &&
            ((this.s_field4==null && other.getS_field4()==null) || 
             (this.s_field4!=null &&
              this.s_field4.equals(other.getS_field4()))) &&
            ((this.s_field5==null && other.getS_field5()==null) || 
             (this.s_field5!=null &&
              this.s_field5.equals(other.getS_field5())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getS_field1() != null) {
            _hashCode += getS_field1().hashCode();
        }
        if (getS_field2() != null) {
            _hashCode += getS_field2().hashCode();
        }
        if (getS_field3() != null) {
            _hashCode += getS_field3().hashCode();
        }
        if (getS_field4() != null) {
            _hashCode += getS_field4().hashCode();
        }
        if (getS_field5() != null) {
            _hashCode += getS_field5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RfidTagInfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://MedicinesInfoWS.webservice", "RfidTagInfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_field1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_field1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_field2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_field2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_field3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_field3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_field4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_field4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_field5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "s_field5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
