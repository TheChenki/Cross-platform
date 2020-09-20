package junit.tests.framework;

import junit.framework.*;

/**
 * A test case testing the testing junit.framework.
 *
 */
public class Failure extends TestCase {
	public void runTest() {
		fail();
	}
}