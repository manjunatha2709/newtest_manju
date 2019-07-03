package com.symantec.vip.automation.eg.radius;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
	String vendorName;
	List<Application> applications;
	String _id;
	Long _version;
	

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(ArrayList<Application> applications) {
		this.applications = applications;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long get_version() {
		return _version;
	}

	public void set_version(Long _version) {
		this._version = _version;
	}
}
