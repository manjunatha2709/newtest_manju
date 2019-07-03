package com.symantec.vip.automation.ldap;import java.io.PrintWriter;import java.io.StringWriter;import java.util.Hashtable;import java.util.Map;import java.util.Properties;import javax.naming.Context;import javax.naming.NamingEnumeration;import javax.naming.NamingException;import javax.naming.directory.Attributes;import javax.naming.directory.BasicAttribute;import javax.naming.directory.DirContext;import javax.naming.directory.InitialDirContext;import javax.naming.directory.ModificationItem;import javax.naming.directory.SearchControls;import javax.naming.directory.SearchResult;import javax.naming.ldap.InitialLdapContext;import javax.naming.ldap.LdapContext;import org.apache.log4j.Logger;import com.symantec.vip.automation.utils.AutomationProperties;public class LDAPHelper {	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");	Properties properties = AutomationProperties.getInstance().GetAutomationProperties();	public boolean updatePassword(Map<String, String> config) throws Exception {		logger.info("Updating AD user password");		boolean result = false;		DirContext ldapContext;		String baseName = config.get("ldap_base_dn").trim();		String ldapHost = config.get("ldap_host_name").trim();		// ldapHost =properties.getProperty(ldapHost).trim();		String ldapPort = "636";		String adminDN = config.get("ldap_bind_user_dn").trim();		String adminPassword = config.get("ldap_bind_user_password").trim();		String userName = config.get("user_name").trim();		if (config.get("user_name").contains("\\")) {			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Found the username format in <Domain\\user> ");			userName = config.get("user_name").split("\\\\")[1].trim();		}		String userPassword = config.get("user_ldap_password").trim();		System.setProperty("javax.net.ssl.trustStore", "/Users/vipeg/Documents/Automation/Resources/cacerts");		System.setProperty("javax.net.debug", "all");		Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");		ldapEnv.put(Context.PROVIDER_URL, "ldap://" + ldapHost + ":" + ldapPort);		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");		ldapEnv.put(Context.SECURITY_PRINCIPAL, adminDN);		ldapEnv.put(Context.SECURITY_CREDENTIALS, adminPassword);		ldapEnv.put(Context.SECURITY_PROTOCOL, "ssl");		ldapContext = new InitialDirContext(ldapEnv);		String quotedPassword = "\"" + userPassword + "\"";		char unicodePwd[] = quotedPassword.toCharArray();		byte pwdArray[] = new byte[unicodePwd.length * 2];		for (int i = 0; i < unicodePwd.length; i++) {			pwdArray[i * 2 + 1] = (byte) (unicodePwd[i] >>> 8);			pwdArray[i * 2 + 0] = (byte) (unicodePwd[i] & 0xff);		}		ModificationItem[] mods = new ModificationItem[1];		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("UnicodePwd", pwdArray));		LdapContext ctx = null;		ctx = new InitialLdapContext(ldapEnv, null);		String dn = getDistingushedName(userName, ctx, "DC=xuv,DC=prupleclub,DC=europe,DC=internal");		System.out.println("User DN is " + dn);		ldapContext.modifyAttributes(dn, mods);		result = true;		return result;	}	public void updateAttribute(Map<String, String> config, String attrName, String attrValue) throws Exception {		logger.info("Updating AD user property pwdLastSet to 0 to prompt to change the password at next logon");		DirContext ldapContext;		String baseName = config.get("ldap_base_dn").trim();		String ldapHost = config.get("ldap_host_name").trim();		// ldapHost =properties.getProperty(ldapHost).trim();		String ldapPort = "636";		String adminDN = config.get("ldap_bind_user_dn").trim();		String adminPassword = config.get("ldap_bind_user_password").trim();		String userName = config.get("user_name").trim();		if (config.get("user_name").contains("\\")) {			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Found the username format in <Domain\\user> ");			userName = config.get("user_name").split("\\\\")[1].trim();		}		System.setProperty("javax.net.ssl.trustStore", "/Users/vipeg/Documents/Automation/Resources/cacerts");		System.setProperty("javax.net.debug", "all");		Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");		ldapEnv.put(Context.PROVIDER_URL, "ldap://" + ldapHost + ":" + ldapPort);		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");		ldapEnv.put(Context.SECURITY_PRINCIPAL, adminDN);		ldapEnv.put(Context.SECURITY_CREDENTIALS, adminPassword);		ldapEnv.put(Context.SECURITY_PROTOCOL, "ssl");		ldapContext = new InitialDirContext(ldapEnv);		ModificationItem[] mods = new ModificationItem[1];		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(attrName, attrValue));		LdapContext ctx = null;		ctx = new InitialLdapContext(ldapEnv, null);		String dn = getDistingushedName(userName, ctx, "DC=xuv,DC=prupleclub,DC=europe,DC=internal");		System.out.println("User DN is " + dn);		ldapContext.modifyAttributes(dn, mods);		// System.out.println("User DN is " + "cn=" + userName + "," +		// baseName);		// ldapContext.modifyAttributes("cn=" + userName + "," + baseName,		// mods);	}	// public static void main(String[] args) {	// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());	// // the keystore that holds trusted root certificates	// Map<String, String> config = new HashMap<String, String>();	// LDAPHelper adc = new LDAPHelper();	// config.put("ldap_base_dn",	// "OU=Automation_DONT_DELETE,DC=xuv,DC=prupleclub,DC=europe,DC=internal");	// config.put("ldap_host_name",	// "symc-2k8-17-75.xuv.prupleclub.europe.internal");	// config.put("ldap_host_port", "636");	// config.put("ldap_bind_user_dn",	// "CN=binduser_automation,OU=Automation_DONT_DELETE,DC=xuv,DC=prupleclub,DC=europe,DC=internal");	// config.put("ldap_bind_user_password", "P@ssword1");	// config.put("user_name", "bobby");	// config.put("user_ldap_password", "1Password");	// adc.updatePassword(config);	// adc.updateAttribute(config, "pwdLastSet", "0");	// }	public String Stack2string(Throwable e) {		try {			StringWriter sw = new StringWriter();			PrintWriter pw = new PrintWriter(sw);			e.printStackTrace(pw);			return "------\r\n" + sw.toString() + "------\r\n";		} catch (Exception e2) {			return "bad stack2string";		}	}	/*	 * private User getUserBasicAttributes(String username, LdapContext ctx) {	 * User user=null; try {	 * 	 * 	 * 	 * SearchControls constraints = new SearchControls();	 * constraints.setSearchScope(SearchControls.SUBTREE_SCOPE); String[]	 * attrIDs = { "distinguishedName", "sn", "givenname", "mail",	 * "telephonenumber"}; constraints.setReturningAttributes(attrIDs); //First	 * input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"	 * //Second Attribute can be uid=username NamingEnumeration answer =	 * ctx.search("DC=YourDomain,DC=com", "sAMAccountName=" + username,	 * constraints); if (answer.hasMore()) { Attributes attrs = ((SearchResult)	 * answer.next()).getAttributes(); System.out.println("distinguishedName "+	 * attrs.get("distinguishedName")); System.out.println("givenname "+	 * attrs.get("givenname")); System.out.println("sn "+ attrs.get("sn"));	 * System.out.println("mail "+ attrs.get("mail"));	 * System.out.println("telephonenumber "+ attrs.get("telephonenumber"));	 * }else{ throw new Exception("Invalid User"); }	 * 	 * } catch (Exception ex) { ex.printStackTrace(); } return user; }	 */	private String getDistingushedName(String username, LdapContext ctx, String domainDn) {		String dn = null;		try {			SearchControls constraints = new SearchControls();			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);			String[] attrIDs = { "distinguishedName", "sn", "givenname", "mail", "telephonenumber" };			constraints.setReturningAttributes(attrIDs);			// First input parameter is search bas, it can be			// "CN=Users,DC=YourDomain,DC=com"			// Second Attribute can be uid=username			NamingEnumeration answer;			if (username.contains("@")) {				answer = ctx.search(domainDn, "userprincipalname=" + username, constraints);			} else {				answer = ctx.search(domainDn, "sAMAccountName=" + username, constraints);			}			if (answer.hasMore()) {				Attributes attrs = ((SearchResult) answer.next()).getAttributes();				dn = attrs.get("distinguishedName").toString();				dn = dn.split(":")[1].trim();				dn = dn.replace("\\", "\\\\");				// System.out.println("distinguishedName " +				// attrs.get("distinguishedName"));				// System.out.println("givenname " + attrs.get("givenname"));				// System.out.println("sn " + attrs.get("sn"));				// System.out.println("mail " + attrs.get("mail"));				// System.out.println("telephonenumber " +				// attrs.get("telephonenumber"));			} else {				throw new Exception("Invalid User");			}		} catch (Exception ex) {			ex.printStackTrace();		}		return dn;	}}