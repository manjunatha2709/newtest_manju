package com.symantec.vip.soapclient;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URL;

import org.apache.log4j.Logger;
import com.symantec.vip.schemas._2006._08.vipservice.GetServerTimeResponseType;
import com.symantec.vip.schemas._2006._08.vipservice.GetServerTimeType;
import com.symantec.vip.schemas._2006._08.vipservice.GetTokenInformationResponseType;
import com.symantec.vip.schemas._2006._08.vipservice.GetTokenInformationType;
import com.symantec.vip.schemas._2006._08.vipservice.TokenIdType;
import com.symantec.vip.schemas._2006._08.vipservice.UnlockTokenResponseType;
import com.symantec.vip.schemas._2006._08.vipservice.UnlockTokenType;
import com.symantec.vip.schemas._2006._08.vipservice.VipSoapInterface;
import com.symantec.vip.schemas._2006._08.vipservice.VipSoapInterfaceService;
import com.symantec.vip.schemas._2006._08.vipservice.VipSoapInterfaceServiceLocator;

public class Credential {
	public static Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	VipSoapInterfaceService service;
	VipSoapInterface port;
	String m_url;
	String version = "2.0";
	String nonce = "abcd1234";// 
	String authAccount = null;
	String certFile; // replace with your cert file
	String password; // replace with the password for the cert
	public Credential(String url, String vipCertFilePath, String vipCertPassword) {
		try{
			logger.info("soap URL is:"+url);
			logger.info("vip cert path is:"+vipCertFilePath);
			logger.info("vip cert password  is:"+vipCertPassword);
			this.certFile = vipCertFilePath;
			this.password = vipCertPassword;
			service =new VipSoapInterfaceServiceLocator();
			m_url = url;
			//System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
			System.setProperty("javax.net.ssl.keyStoreType", "jks");
			System.setProperty("javax.net.ssl.keyStore", certFile);
			System.setProperty("javax.net.ssl.keyStorePassword", password);
		}
		catch (Exception e){
			logger.info(Stack2string(e));
			System.out.println("Exception : " + e);
		} 
	}
	public String GetServerTime(){
		try{
			URL url = new java.net.URL(m_url+"/prov/soap");
			port = service.getvipServiceAPI(url);

			GetServerTimeType x = new GetServerTimeType(version,nonce); GetServerTimeResponseType resp = port.getServerTime(x);
			BigInteger reason = new
					BigInteger(resp.getStatus().getReasonCode());
			if (reason.intValue() != 0){
				System.out.println("Message = " + resp.getStatus().getStatusMessage()); System.out.println("Error Detail = " + resp.getStatus().getErrorDetail()); return null;
			}else{
				return (resp.getTimestamp().getTime().toString());
			}
		}
		catch (Exception e){
			logger.info(Stack2string(e));
			System.out.println("GetServerTime(), Exception : " + e);
			return null;
		}
	}
	public void getTokenInformation(String credId) {
		try{
			port = service.getvipServiceAPI(new java.net.URL(m_url+"/mgmt/soap"));

			TokenIdType tokenIDType = new TokenIdType();
			tokenIDType.set_value(credId);
			// A reseller account can perform operations on behalf of the customer account
			// specified in AuthorizerAccountId. For non-reseller accounts (the default case)
			// specify AuthorizerAccountId as null.
			GetTokenInformationType x = new
					GetTokenInformationType(version,nonce,null,tokenIDType);
			GetTokenInformationResponseType resp =  port.getTokenInformation(x);
			BigInteger reason = new BigInteger(resp.getStatus().getReasonCode());
			if (reason.intValue() != 0){
				System.out.println("Message = " +
						resp.getStatus().getStatusMessage());
				System.out.println("Error Detail = " +
						resp.getStatus().getErrorDetail());
			}else{
				System.out.println("Result = " +
						resp.getStatus().getStatusMessage());
				System.out.println("Token Id = " +
						resp.getTokenInformation().getTokenId());
				System.out.println("Token Kind = " +
						resp.getTokenInformation().getTokenKind());
				System.out.println("Adapter = " +
						resp.getTokenInformation().getAdapter());
				System.out.println("Token Status = " +
						resp.getTokenInformation().getTokenStatus());
				System.out.println("Expiration Date = " +
						resp.getTokenInformation().getExpirationDate().getTime().
						toString());
				if(resp.getTokenInformation().getTempPasswordExpirationDate()
						!= null)
					System.out.println("Temp pwd expiration Date = " + resp.getTokenInformation().getTempPasswordExpirationDate() .getTime().toString());
				System.out.println("Owner = " +
						resp.getTokenInformation().getOwner().toString());
				System.out.println("Last update = " +
						resp.getTokenInformation().getLastUpdate().getTime().
						toString());
			}
		}
		catch (Exception e){
			logger.info(Stack2string(e));
			System.out.println("getTokenInformation(), Exception : " + e);
		}
	}

	public String UnlockToken(String credId) {
		UnlockTokenResponseType resp1 = null;
		try{
			logger.info("initialising to Unlock Credential ws API on");
			port = service.getvipServiceAPI(new java.net.URL(m_url+"/mgmt/soap"));

			TokenIdType tokenIDType = new TokenIdType();
			tokenIDType.set_value(credId);
			// A reseller account can perform operations on behalf of the customer account
			// specified in AuthorizerAccountId. For non-reseller accounts (the default case)
			// specify AuthorizerAccountId as null.
			UnlockTokenType x1 = new UnlockTokenType(version,nonce,null,tokenIDType);
			resp1 = port.unlockToken(x1);
			BigInteger reason = new BigInteger(resp1.getStatus().getReasonCode());
			if (reason.intValue() != 0){
				logger.info("Message = " +
						resp1.getStatus().getStatusMessage());
				logger.info("Error Detail = " +
						resp1.getStatus().getErrorDetail());
				return resp1.getStatus().getStatusMessage()+". "+resp1.getStatus().getErrorDetail();
			}else{
				logger.info("Result = " +
						resp1.getStatus().getStatusMessage());
				return resp1.getStatus().getStatusMessage();


			}
		}catch (Exception e){
			logger.info(Stack2string(e));
			System.out.println("getTokenInformation(), Exception : " + e);
			return "Exception occured. "+resp1.getStatus().getStatusMessage()+". "+resp1.getStatus().getErrorDetail();
		}

	}
	
	protected String Stack2string(Throwable e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return "------\r\n" + sw.toString() + "------\r\n";
		}
		catch(Exception e2) {
			return "bad stack2string";
		}
	}
	
}
