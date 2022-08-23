package net.eshin.sql.utils.sqlrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public final class CustomScriptRunner {

	final SQLServerDataSource ds;
	final String scriptsFolder;

	public CustomScriptRunner(ArgumentManager manager) {
		this.ds = manager.getDatasource();
		this.scriptsFolder = manager.getScriptFolder();
	}

	public void runMyScripts() throws FileNotFoundException, SQLException {
		final File dir = new File(scriptsFolder);
		final List<File> li = Arrays.asList(dir.listFiles());
		for (final File file : li) {
			if (!file.isDirectory()) {
				System.out.println(file.getAbsolutePath());
				runSqlFiles(file);
			}
		}
	}

	private void runSqlFiles(final File file) throws SQLException, FileNotFoundException {
		// Registering the Driver
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		// Getting the connection
		try (Connection con = ds.getConnection()) {
			System.out.println("Connection established......");
			// Initialize the script runner
			final ScriptRunner sr = new ScriptRunner(con);
			// Creating a reader object
			final Reader reader = new BufferedReader(new FileReader(file));
			// Running the script
			sr.setFullLineDelimiter(true);
			sr.setDelimiter("GO");
			sr.setAutoCommit(true);
			sr.setStopOnError(true);
			sr.runScript(reader);
		}
	}
}
