/**
 * MedicineInfoWSIFServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package webservice.MedicinesInfoWS;

public class MedicineInfoWSIFServiceLocator extends org.apache.axis.client.Service implements webservice.MedicinesInfoWS.MedicineInfoWSIFService {

    public MedicineInfoWSIFServiceLocator() {
    }


    public MedicineInfoWSIFServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MedicineInfoWSIFServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MedicinesInfoWS
    private java.lang.String MedicinesInfoWS_address = "http://www.kpis.or.kr/services/MedicinesInfoWS";

    public java.lang.String getMedicinesInfoWSAddress() {
        return MedicinesInfoWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MedicinesInfoWSWSDDServiceName = "MedicinesInfoWS";

    public java.lang.String getMedicinesInfoWSWSDDServiceName() {
        return MedicinesInfoWSWSDDServiceName;
    }

    public void setMedicinesInfoWSWSDDServiceName(java.lang.String name) {
        MedicinesInfoWSWSDDServiceName = name;
    }

    public webservice.MedicinesInfoWS.MedicineInfoWSIF getMedicinesInfoWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MedicinesInfoWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMedicinesInfoWS(endpoint);
    }

    public webservice.MedicinesInfoWS.MedicineInfoWSIF getMedicinesInfoWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservice.MedicinesInfoWS.MedicinesInfoWSSoapBindingStub _stub = new webservice.MedicinesInfoWS.MedicinesInfoWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getMedicinesInfoWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMedicinesInfoWSEndpointAddress(java.lang.String address) {
        MedicinesInfoWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservice.MedicinesInfoWS.MedicineInfoWSIF.class.isAssignableFrom(serviceEndpointInterface)) {
                webservice.MedicinesInfoWS.MedicinesInfoWSSoapBindingStub _stub = new webservice.MedicinesInfoWS.MedicinesInfoWSSoapBindingStub(new java.net.URL(MedicinesInfoWS_address), this);
                _stub.setPortName(getMedicinesInfoWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MedicinesInfoWS".equals(inputPortName)) {
            return getMedicinesInfoWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://MedicinesInfoWS.webservice", "MedicineInfoWSIFService");
    }

    private java.util.HashSet ports = null;

    @SuppressWarnings("unchecked")
    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://MedicinesInfoWS.webservice", "MedicinesInfoWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MedicinesInfoWS".equals(portName)) {
            setMedicinesInfoWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
