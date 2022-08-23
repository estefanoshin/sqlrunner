package net.eshin.sql.utils.sqlrunner;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class App {

	static {
		printInfo();
	}

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		long initTime = System.currentTimeMillis();
		final ArgumentManager manager = new ArgumentManager(args);
		try {
			new CustomScriptRunner(manager).runMyScripts();
		} finally {
			long finalTime = System.currentTimeMillis();
			System.out.println("START: " + initTime);
			System.out.println("END: " + finalTime);
		}
	}

	private static void printInfo() {
		System.out.println("Ingrese los parametro necesarios: ");
		System.out.println("-Duser=\"DATABASE_USER\"");
		System.out.println("-Dpassword=\"DATABASE_PASSWORD\"");
		System.out.println("-Dserver=\"DATABASE_SERVER_IP\"");
		System.out.println("-Dport=DATABSE_PORT_NUMBER");
		System.out.println("-Ddatabase=\"DATABASE_NAME\"");
		System.out.println("-DscriptFolder=\"FOLDER_WITH_SCRIPTS_LOCATION\"");
	}

}
