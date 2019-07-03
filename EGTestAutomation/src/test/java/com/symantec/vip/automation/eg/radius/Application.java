package com.symantec.vip.automation.eg.radius;

import java.util.List;

public class Application {
	String applicationName;
	List<String> modes;
	boolean Delegation;
	String type;
	boolean challengeSupported;
	boolean ldapToRadiusMapping;
	boolean pinReset;
	String _id;
	int _version;

	public boolean isPinReset() {
		return pinReset;
	}

	public void setPinReset(boolean pinReset) {
		this.pinReset = pinReset;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public List<String> getModes() {
		return modes;
	}

	public void setModes(List<String> modes) {
		this.modes = modes;
	}

	public boolean isDelegation() {
		return Delegation;
	}

	public void setDelegation(boolean delegation) {
		Delegation = delegation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isChallengeSupported() {
		return challengeSupported;
	}

	public void setChallengeSupported(boolean challengeSupported) {
		this.challengeSupported = challengeSupported;
	}

	public boolean isLdapToRadiusMapping() {
		return ldapToRadiusMapping;
	}

	public void setLdapToRadiusMapping(boolean ldapToRadiusMapping) {
		this.ldapToRadiusMapping = ldapToRadiusMapping;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int get_version() {
		return _version;
	}

	public void set_version(int _version) {
		this._version = _version;
	}
}
