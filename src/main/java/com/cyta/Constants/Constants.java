package com.cyta.Constants;

public class Constants {
	
	public static final String FileSeprator= System.getProperty("file.separator");
	
	public static final String javaFoldermain= System.getProperty("user.dir")+
			FileSeprator+"src"+FileSeprator
			+"main"+FileSeprator+"java"+FileSeprator;
	
	public static final String Foldertest= System.getProperty("user.dir")+
			FileSeprator+"src"+FileSeprator
			+"test"+FileSeprator;
	
	public static final String testDataPath=Foldertest+"resources"+FileSeprator+"Resources"+FileSeprator;
	public static final String ConfigPath=javaFoldermain+"com"+FileSeprator+"cyta"
	+FileSeprator+"ConfigrationsFiles"+FileSeprator;
	public static final String APKinfo=javaFoldermain+"";
	public static final String AppCredentialsConfigPath=javaFoldermain+"";

}

