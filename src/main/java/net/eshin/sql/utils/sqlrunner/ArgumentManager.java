package net.eshin.sql.utils.sqlrunner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public final class ArgumentManager {

	private final SQLServerDataSource dataSource;
	private final String scriptFolder;

	public ArgumentManager(final String[] args) {
		final String user = System.getProperty("username");
		final String password = System.getProperty("password");
		final String server = System.getProperty("server");
		final String port = System.getProperty("port");
		final String database = System.getProperty("database");
		final String scriptFolder = System.getProperty("scriptFolder");

		if (scriptFolder == null)
			throw new RuntimeException("Insert a scriptFolder");

		this.dataSource = new DataSourceUtil.Builder() //
				.withUser(user) //
				.withPassword(password) //
				.withServer(server) //
				.withPort(port) //
				.withDatabase(database) //
				.build();

		this.scriptFolder = scriptFolder;
	}

	public SQLServerDataSource getDatasource() {
		return dataSource;
	}

	public String getScriptFolder() {
		return scriptFolder;
	}
}
