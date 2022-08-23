package net.eshin.sql.utils.sqlrunner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DataSourceUtil {

	public static final class Builder {
		private String user;
		private String password;
		private String server;
		private int port;
		private String database;

		public Builder withUser(final String user) {
			this.user = user;
			return this;
		}

		public Builder withPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder withServer(final String server) {
			this.server = server;
			return this;
		}

		public Builder withPort(final String port) {
			this.port = Integer.valueOf(port);
			return this;
		}

		public Builder withDatabase(final String database) {
			this.database = database;
			return this;
		}

		public SQLServerDataSource build() {
			if (user == null)
				throw new RuntimeException("Insert a user");

			if (password == null)
				throw new RuntimeException("Insert a password");

			if (server == null)
				throw new RuntimeException("Insert a server");

			if (port == 0)
				throw new RuntimeException("Insert a port");

			if (database == null)
				throw new RuntimeException("Insert a database");

			return new DataSourceUtil(this).getDataSource();
		}
	}

	private final String user;
	private final String password;
	private final String server;
	private final int port;
	private final String database;

	public DataSourceUtil(final Builder builder) {
		this.user = builder.user;
		this.password = builder.password;
		this.server = builder.server;
		this.port = builder.port;
		this.database = builder.database;
	}

	private SQLServerDataSource getDataSource() {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser(this.user);
		ds.setPassword(this.password);
		ds.setServerName(this.server);
		ds.setPortNumber(this.port);
		ds.setDatabaseName(this.database);

		return ds;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}

	public String getDatabase() {
		return database;
	}
}
