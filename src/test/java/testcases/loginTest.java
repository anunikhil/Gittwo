package testcases;

import org.testng.annotations.Test;

import excelengine.Engine;

public class loginTest {
public Engine engine;
		
	@Test
	public void logintest() {
		engine = new Engine();
		engine.StartExecution("login");
		
	}
}
