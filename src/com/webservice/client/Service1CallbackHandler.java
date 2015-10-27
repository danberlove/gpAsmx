/**
 * Service1CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package com.webservice.client;


/**
 *  Service1CallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class Service1CallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public Service1CallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public Service1CallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getMobileAddress method
     * override this method for handling normal response from getMobileAddress operation
     */
    public void receiveResultgetMobileAddress(
        com.webservice.client.Service1Stub.GetMobileAddressResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMobileAddress operation
     */
    public void receiveErrorgetMobileAddress(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addressSearch method
     * override this method for handling normal response from addressSearch operation
     */
    public void receiveResultaddressSearch(
        com.webservice.client.Service1Stub.AddressSearchResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addressSearch operation
     */
    public void receiveErroraddressSearch(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getChinaAddr method
     * override this method for handling normal response from getChinaAddr operation
     */
    public void receiveResultgetChinaAddr(
        com.webservice.client.Service1Stub.GetChinaAddrResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getChinaAddr operation
     */
    public void receiveErrorgetChinaAddr(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addressSearch_PY_2 method
     * override this method for handling normal response from addressSearch_PY_2 operation
     */
    public void receiveResultaddressSearch_PY_2(
        com.webservice.client.Service1Stub.AddressSearch_PY_2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addressSearch_PY_2 operation
     */
    public void receiveErroraddressSearch_PY_2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for healthtest method
     * override this method for handling normal response from healthtest operation
     */
    public void receiveResulthealthtest(
        com.webservice.client.Service1Stub.HealthtestResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from healthtest operation
     */
    public void receiveErrorhealthtest(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addressSearch_PY method
     * override this method for handling normal response from addressSearch_PY operation
     */
    public void receiveResultaddressSearch_PY(
        com.webservice.client.Service1Stub.AddressSearch_PYResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addressSearch_PY operation
     */
    public void receiveErroraddressSearch_PY(java.lang.Exception e) {
    }
}
