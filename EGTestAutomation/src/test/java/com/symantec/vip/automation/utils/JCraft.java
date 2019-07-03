package com.symantec.vip.automation.utils;

import com.jcraft.jsch.*;
import java.io.*;

public class JCraft{

	public InputStream getFile(String remoteHost, String remoteUsername, String remotePassword, String remoteFilePath) throws JSchException, IOException, SftpException{
		InputStream out = null;
		JSch jsch=new JSch();
		java.util.Properties config = new java.util.Properties(); 
		try {
			config.put("StrictHostKeyChecking", "no");
			Session session=jsch.getSession(remoteUsername, remoteHost, 22);
			session.setConfig(config);
			session.setPassword(remotePassword);
			session.connect();
			ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
			sftp.connect();
			out = sftp.get("BuildList.txt");
			System.out.println("Out is "+out);
		} catch (Exception e) {
			System.out.println(e);
		}
		return out; 

	}
}
