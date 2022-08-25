package net.eshin.sql.utils.sqlrunner.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import net.eshin.sql.utils.sqlrunner.ArgumentManager;
import net.eshin.sql.utils.sqlrunner.CustomScriptRunner;

public class ScriptRunnerController {

	public static void runScripts(ArgumentManager manager)
			throws SQLException, UnsupportedEncodingException, IOException {
		long initTime = System.currentTimeMillis();
		try {
			new CustomScriptRunner(manager).runMyScripts();
		} finally {
			long finalTime = System.currentTimeMillis();
			System.out.println("START: " + initTime);
			System.out.println("END: " + finalTime);
		}
	}
}
