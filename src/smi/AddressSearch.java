package smi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.util.StreamWrapper;

import com.webservice.client.Service1Stub;

import samples.quickstart.clients.QueryServiceStub;

public class AddressSearch {
    
    public void searchAddress() throws RemoteException, ADBException, XMLStreamException
    {
        String soapaction="http://tempuri.org/";   //域名，这是在server定义的
        String methodName="AddressSearch";   //调用的方法名
        
//        web service
        Service1Stub stub = new Service1Stub();
        
//        method
        Service1Stub.AddressSearch addressSearch = new Service1Stub.AddressSearch();
//    	QueryServiceStub.JGetGIS getGis = new QueryServiceStub.JGetGIS();
        
//        set parameter
        addressSearch.setSAddress("武宁路");
        addressSearch.setM_len(12);
//		QueryServiceStub.ArrayOfString any = new QueryServiceStub.ArrayOfString();
//		String[] arcNum = new String[2];
//		arcNum[0] = "E";
//		any.setString(arcNum);
//		getGis.setAlComplex(any);
		
//        call web service method
        Service1Stub.AddressSearchResponse res = stub.addressSearch(addressSearch);
//		QueryServiceStub.JGetGISResponse res = stub.jGetGIS(getGis);
        
//        get result
        Service1Stub.ArrayOfAddressR data = res.getAddressSearchResult();
//		QueryServiceStub.ArrayOfJGisData data = res.getJGetGISResult();
        
        Service1Stub.AddressR[] arrayAddressR = data.getAddressR();
//		TODO
//		QueryServiceStub.JGisData[] jgdArray = data.getJGisData();
    	
		for(int i = 0; i < arrayAddressR.length; i++){
			Service1Stub.AddressR jgd = arrayAddressR[i];
			
//			get data
			String district = jgd.getM_District();
			System.out.println(district);
			String POIName = jgd.getM_POIName();
			System.out.println(POIName);
			String DoorPlate = jgd.getM_DoorPlate();
			System.out.println(DoorPlate);
			double Lon = jgd.getM_Lon();
			System.out.println(Lon);
			double Lat = jgd.getM_Lat();
			System.out.println(Lat);
			
			
//			TODO
			XMLStreamReader xmlReader = jgd.getPullParser(new QName(soapaction, methodName));
			
			/*
			 * ref: 深入剖析Axis2中参数为复杂自定义类型值
			 * http://blog.csdn.net/yuebinghaoyuan/article/details/8445885
			 */
			StreamWrapper parser = new StreamWrapper(xmlReader);
			StAXOMBuilder stAXOMBuilder = (StAXOMBuilder) OMXMLBuilderFactory.createStAXOMBuilder(OMAbstractFactory. getOMFactory(), parser);
			OMElement element = stAXOMBuilder.getDocumentElement();//得到xml字符串
			System. out.println(element);
			
			/*
			 * ref
			 * http://blog.csdn.net/is_zhoufeng/article/details/8309392
			 */
			while(xmlReader.hasNext()){
	            int point = xmlReader.next();
	            
	            String localName = xmlReader.getLocalName();
	            String value = xmlReader.getAttributeValue(null, localName);
//	            String eleName = xmlReader.getName().toString();
//	            QName name = xmlReader.getName();
//	            value = (String) xmlReader.getProperty(localName);
                String a = "";
	            
//	            switch(point){  
//	            case XMLStreamReader.START_ELEMENT :{   //开始节点  
//	                eleName = xmlReader.getName().toString();  
//	                if("property".equals(eleName)){  
//	                    int attCount = xmlReader.getAttributeCount() ;  
//	                    for (int j = 0; j < attCount; j++) {  
//	                        System.out.printf("%s:%s\t" ,  
//	                        		xmlReader.getAttributeName(j) ,  
//	                        		xmlReader.getAttributeValue(j));  
//	                    }  
//	                    System.out.println();  
//	                }  
//	            }  
//	            case XMLStreamReader.END_ELEMENT :{   //结束节点  
//	  
//	            }  
//	            case XMLStreamReader.CHARACTERS :{  //文本节点
//	            }  
//	  
//	            }  
	        }
		}
    }
    
    public static void main(String args[]) throws RemoteException, MalformedURLException, ServiceException, ADBException, XMLStreamException
    {
	    AddressSearch pw = new AddressSearch();
	    pw.searchAddress();
    }
}
