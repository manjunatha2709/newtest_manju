package com.symantec.vip.automation.eg.radius;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.testng.Assert;

import com.symantec.vip.automation.restapi.RestClient;

public class PerfTest {
	static Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	RestClient rClient = new RestClient();

	public void InvokePerfTest(Map<String, String> config) {
		ArrayList<FinalResult> finalExecutionStatus = new ArrayList<FinalResult>();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<Integer, FinalResult> result;
		try {
			result = rClient.PerformRemoteActionForPerfTest("InvokePerfTest", config);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "config status is " + result);
			Assert.assertEquals(true, result.get(0) != null);
			int i = 0;
			for (int key : result.keySet()) {
				finalExecutionStatus.add(i, result.get(i));
				i++;
				System.out.println("map.get = " + result.get(key));
			}
			CreateChart(config.get("chart_name"), finalExecutionStatus);
		} catch (Exception e) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "exception : " + e.getMessage());
			Assert.assertTrue(false, "exception : " + e.getMessage());
		} finally {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	public static void CreateChart(String chartName, ArrayList<FinalResult> finalExecutionStatus) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Integer> getTotalAuthCountTracking = new ArrayList<Integer>();
		String path = null;
		for (FinalResult fr1 : finalExecutionStatus) {
			int numCount = 1;
			for (Integer int1 : getTotalAuthCountTracking) {
				if (int1 == fr1.getTotalAuthenticationCount()) {
					numCount++;
				}
			}
			dataset.setValue(fr1.getAvarageTimeTaken(), "IT" + String.valueOf(numCount), String.valueOf(fr1.getTotalAuthenticationCount()));
			getTotalAuthCountTracking.add(fr1.getTotalAuthenticationCount());
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": "
			+ "===========================================================================================================================================================================");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "     Iteration No.   ||   Total Authentication Request   ||   Avarage Time Taken(Milli Sec)   ||   No response received ");
		for (FinalResult fr1 : finalExecutionStatus) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "     " + fr1.getExecutionCount() + "                       " + fr1.totalAuthenticationCount
				+ "                                   " + fr1.getAvarageTimeTaken() + "                                   " + fr1.getNoOfNoResponse());
		}
		// Profit1, Profit2 represent the row keys
		// Jane, Tom, Jill, etc. represent the column keys
		JFreeChart chart = ChartFactory.createBarChart3D("Radius Performance Testing " + chartName, // Chart
			// name
			"Number of Authentication Requests", // X axis label
			"Avg Time-Taken/Req (in ms)", // Y axis value
			dataset, // data set
			PlotOrientation.VERTICAL, true, true, false);
		try {
			String workingDir = System.getProperty("user.dir");
			for (int i = 1; i < 10; i++) {
				File f = new File("Chart" + i + ".jpg");
				if (!f.exists() && !f.isDirectory()) {
					path = "Chart" + i + ".jpg";
					break;
				}
			}
			ChartUtilities.saveChartAsJPEG(new File(path), chart, 500, 300);
			// write an HTML page incorporating the image with an image map
			// final File file2 = new File(workingDir + "//Chart.html");
			// final OutputStream out = new BufferedOutputStream(new
			// FileOutputStream(file2));
			// final PrintWriter writer = new PrintWriter(out);
			// writer.println("<HTML>");
			// writer.println("<HEAD><TITLE>Performance Test Report</TITLE></HEAD>");
			// writer.println("<BODY>");
			// String imageString = "<IMG SRC=\"" + path + "\"\" ";
			// writer.println(imageString +
			// "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");
			// writer.println("</BODY>");
			// writer.println("</HTML>");
			// writer.close();
		} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
		}
	}

	public void createHTML() throws FileNotFoundException {
		final File file2 = new File("Performance_Test_Report.html");
		final OutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
		final PrintWriter writer = new PrintWriter(out);
		writer.println("<HTML>");
		writer.println("<HEAD><TITLE>Performance Test Report</TITLE></HEAD>");
		writer.println("<BODY>");
		String path = null;
		for (int i = 1; i < 10; i++) {
			File f = new File("Chart" + i + ".jpg");
			if (f.exists() && !f.isDirectory()) {
				writer.println("<br>");
				path = "Chart" + i + ".jpg";
				String imageString = "<IMG SRC=\"" + path + "\"\" ";
				writer.println(imageString + "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");
				writer.println("<br/>");
			}
		}
		writer.println("</BODY>");
		writer.println("</HTML>");
		writer.close();
	}
}
