package net.eshin.sql.utils.sqlrunner;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import net.eshin.sql.utils.sqlrunner.controller.ScriptRunnerController;

public class App {

	static {
		printInfo();
	}

	public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
		final ArgumentManager manager = new ArgumentManager(args);
		ScriptRunnerController.runScripts(manager);
	}

	private static void printInfo() {
		System.out.println("Ingrese los parametro necesarios: ");
		System.out.println("-Dusername=\"DATABASE_USER\"");
		System.out.println("-Dpassword=\"DATABASE_PASSWORD\"");
		System.out.println("-Dserver=\"DATABASE_SERVER_IP\"");
		System.out.println("-Dport=DATABSE_PORT_NUMBER");
		System.out.println("-Ddatabase=\"DATABASE_NAME\"");
		System.out.println("-DscriptFolder=\"FOLDER_WITH_SCRIPTS_LOCATION\"");
	}

}
