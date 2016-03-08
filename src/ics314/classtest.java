import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class classtest {

	@Test
	public void testUserinter() {
		Simpleical test = new Simpleical();
		String x = "Hello\n" + "2321\n2016020s\n20160308\n1300\n13000s\n250000\n130000\n" +
				"2321\n20160s03\n20160308\n1300\n13000s\n250000\n130000\n" +
				"sejiq\n-91\n91\n-83.203\n" +
				"sejiq\n-20\n181\n73.203\n" +
				"391931\nPUBLIC\n" +
				"JunitTesting\n";
		ByteArrayInputStream in = new ByteArrayInputStream(x.getBytes());
		System.setIn(in);
		try {
			test.userinter();
		} catch (IOException e) {
			System.err.println("Problem opening userinter");
		}
		System.setIn(System.in);
	}
}
