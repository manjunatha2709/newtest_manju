package com.symantec.vip.automation.eg.radius;

public class ApplicationTemplate {
	int _version;
	Vendor[] vendors;
	String[] changedAppIds;
	String[] changedVendorIds;

	public Vendor[] getVendors() {
		return vendors;
	}

	public void setVendors(Vendor[] vendors) {
		this.vendors = vendors;
	}

	public String[] getChangedAppIds() {
		return changedAppIds;
	}

	public void setChangedAppIds(String[] changedAppIds) {
		this.changedAppIds = changedAppIds;
	}

	public int get_version() {
		return _version;
	}

	public void set_version(int _version) {
		this._version = _version;
	}

	public String[] getChangedVendorIds() {
		return changedVendorIds;
	}

	public void setChangedVendorIds(String[] changedVendorIds) {
		this.changedVendorIds = changedVendorIds;
	}
}
