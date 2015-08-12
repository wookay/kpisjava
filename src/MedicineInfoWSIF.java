/**
 * MedicineInfoWSIF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package webservice.MedicinesInfoWS;

public interface MedicineInfoWSIF extends java.rmi.Remote {
    public webservice.MedicinesInfoWS.MedicineInfoVO[] retriveStandardCode() throws java.rmi.RemoteException;
    public javax.activation.DataHandler retriveFileOfStandardCode() throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.MedicineInfoVO[] retriveMedicineInfo() throws java.rmi.RemoteException;
    public javax.activation.DataHandler retriveFileOfMedicineInfo() throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.MedicineInfoVO[] retrivePrincipalIngredientInfo() throws java.rmi.RemoteException;
    public javax.activation.DataHandler retriveFileOfPrincipalIngredientInfo() throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.ItemStdCdVO[] getNewItemStdCd(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public javax.activation.DataHandler getNewItemStdCdFile(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.ItemStdCdVO[] getModifyItemStdCd(java.lang.String in0) throws java.rmi.RemoteException;
    public javax.activation.DataHandler getModifyItemStdCdFile(java.lang.String in0) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.ItemStdCdVO[] getDeleteItemStdCd(java.lang.String in0) throws java.rmi.RemoteException;
    public javax.activation.DataHandler getDeleteItemStdCdFile(java.lang.String in0) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.ItemStdCdVO[] getRareStdCd(java.lang.String in0) throws java.rmi.RemoteException;
    public javax.activation.DataHandler getRareStdCdFile(java.lang.String in0) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.NoProductInfoVO[] getNoProductInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public javax.activation.DataHandler getNoProductInfoFile(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.YoyangInfoVO[] retriveYkihoInfo(java.lang.String in0) throws java.rmi.RemoteException;
    public webservice.MedicinesInfoWS.RfidTagInfoVO[] retriveRfidTagInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
}
