package smi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axis2.databinding.ADBException;

import samples.quickstart.clients.QueryServiceStub;

public class ArchihveSearch {
    
    public void JGetMain() throws RemoteException, ADBException, XMLStreamException
    {
        String soapaction="http://tempuri.org/";//域名，这是在server定义的
        String methodName="JGetMain";//调用的方法名
        
        QueryServiceStub stub = new QueryServiceStub();

        QueryServiceStub.JGetMain getMain = new QueryServiceStub.JGetMain();
        getMain.setStrArcNum("E");
        //getMain.setStrClass("");
		
        QueryServiceStub.JGetMainResponse res = stub.jGetMain(getMain);
        QueryServiceStub.ArrayOfJGisData data = res.getJGetMainResult();

//	    TODO 解析结果
        QueryServiceStub.JGisData[] jgdArray = data.getJGisData();
		
        for(int i = 0; i < jgdArray.length; i++){
            QueryServiceStub.JGisData jgd = jgdArray[i];
            
//          尝试一：是否通过这种方式来获取信息？
//          可以得到信息，但好像不完整
            String prjLic = jgd.getStrPrjLic();
            String prjType = jgd.getStrPrjType();
            String region = jgd.getStrRegion();
			
//          尝试二：
//          没有成功，运行报错
            XMLStreamReader xmlReader = jgd.getPullParser(new QName(soapaction, methodName));
			
            QueryServiceStub.Ds_type2 ds = jgd.getDs();
            XMLStreamWriter xmlWriter = null;
//	        QName qn = new QName(soapaction, methodName);
            QName qn = xmlReader.getName();
            ds.serialize(qn, xmlWriter);
        }
    }
    
    public void JGetGIS() throws RemoteException, ADBException, XMLStreamException
    {
        String soapaction="http://tempuri.org/";//域名，这是在server定义的
        String methodName="JGetGIS";//调用的方法名
        
        QueryServiceStub stub = new QueryServiceStub();
    	
        QueryServiceStub.JGetGIS getGis = new QueryServiceStub.JGetGIS();
        QueryServiceStub.ArrayOfString any = new QueryServiceStub.ArrayOfString();
		
        String[] arcNum = new String[2];
		
        arcNum[0] = "E";
		
        any.setString(arcNum);
        getGis.setAlComplex(any);
		
        QueryServiceStub.JGetGISResponse res = stub.jGetGIS(getGis);
        QueryServiceStub.ArrayOfJGisData data = res.getJGetGISResult();

//	    TODO
        QueryServiceStub.JGisData[] jgdArray = data.getJGisData();
		
        for(int i = 0; i < jgdArray.length; i++){
            QueryServiceStub.JGisData jgd = jgdArray[i];

//          尝试一：是否通过这种方式来获取信息？
//          可以得到信息，但好像不完整
            String prjLic = jgd.getStrPrjLic();
            String prjType = jgd.getStrPrjType();
            String region = jgd.getStrRegion();

//          尝试二：
//          没有成功，运行报错
            XMLStreamReader xmlReader = jgd.getPullParser(new QName(soapaction, methodName));
			
            QueryServiceStub.Ds_type2 ds = jgd.getDs();
            XMLStreamWriter xmlWriter = null;
//	        QName qn = new QName(soapaction, methodName);
            QName qn = xmlReader.getName();
            ds.serialize(qn, xmlWriter);
        }
    }
    
    public static void main(String args[]) throws RemoteException, MalformedURLException, ServiceException, ADBException, XMLStreamException
    {
        ArchihveSearch pw = new ArchihveSearch();
//      pw.JGetMain();
        pw.JGetGIS();
    }
}
