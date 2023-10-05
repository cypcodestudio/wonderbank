package com.lekodevs.wonderbank.common;

public enum EAccountTypeLookup {
	
	SAVINGS((long) 1, "SAVINGS"),
	CURRENT((long) 2, "CURRENT");

	private final long id;
    private final String name;
    
	EAccountTypeLookup(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getAccountTypeId() {
		return id;
	}
	public String getAccountTypeName() {
		return name;
	}
	
	

}
