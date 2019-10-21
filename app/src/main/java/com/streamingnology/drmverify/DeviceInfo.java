package com.streamingnology.drmverify;

public class DeviceInfo {
    DeviceInfo(){
        vendor = "";
        version = "";
        description = "";
        algorithms = "";
        securitylevel = "";
        systemid = "";
        hdcplevel = "";
        maxhdcplevel = "";
        usagereportingsupport = "";
        maxnumberofsessions = "";
        numberofopensessions = "";
    }

    public boolean isdrm;
    public String vendor;
    public String version;
    public String description;
    public String algorithms;
    public String securitylevel;
    public String systemid;
    public String hdcplevel;
    public String maxhdcplevel;
    public String usagereportingsupport;
    public String maxnumberofsessions;
    public String numberofopensessions;

    public boolean ishardwareinfo;
    public String brand;
    public String model;
    public String hardware;
    public String sdklevel;

}
