package com.symantec.vip.automation;

import java.io.File;

import autoitx4java.AutoItX;

import com.jacob.com.LibraryLoader;

public class ComHelper {
	public static void main(String[] args) throws InterruptedException {
		File file = new File("src/test/lib", "jacob-1.18-M2-x64.dll"); // path
																		// to
																		// the
																		// jacob
																		// dll
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		String serverName = "10.212.127.219";
		String userName = "XUV\\administrator";
		String password = "P@ssw0rd1";
		AutoItX x = new AutoItX();
		String exeName = "mstsc.exe";
		String rdcTitle = "Remote Desktop Connection";
		String titleWindowsSecurity = "Windows Security";
		x.run(exeName);
		x.winActivate(rdcTitle);
		x.winWaitActive(rdcTitle);
		x.controlClick(rdcTitle, "", "[CLASS:ToolbarWindow32; INSTANCE:1]");
		x.send(serverName);
		x.winWaitActive(rdcTitle);
		x.controlClick(rdcTitle, "", "Button13");
		x.winWaitActive(titleWindowsSecurity);
		x.send("down");
		x.controlSend(titleWindowsSecurity, "", "[CLASS:Edit; INSTANCE:1]", userName);
		x.controlSend(titleWindowsSecurity, "", "[CLASS:Edit; INSTANCE:2]", password);
		x.winWaitActive(titleWindowsSecurity);
		x.controlClick(titleWindowsSecurity, "", "[CLASS:Button; INSTANCE:2]");
		// x.winClose(rdcTitle);
		// // Assert.assertTrue(x.winExists(notepad, testString));
		// // Thread.sleep(2000);
		// // x.winClose(notepad, testString);
		// // Thread.sleep(2000);
		// // x.winWaitActive("Notepad");
		// // x.send("{ALT}n");
		// // Thread.sleep(3000);
		// Assert.assertFalse(x.winExists(notepad, testString));
	}
}
