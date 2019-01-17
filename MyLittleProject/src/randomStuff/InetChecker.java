package randomStuff;

import java.io.IOException;
import java.net.InetAddress;

public class InetChecker {
	public static void main(String[] args) throws IOException {
		String[] addresses = {	"comcave.de","portal.cc-student.com","google.de",
								"bing.com","facebook.com","wikipedia.org"};
		for (String host : addresses) {
			InetAddress tmp = InetAddress.getByName(host);
			System.out.println(tmp + " " + tmp.isReachable(4000));
		}
	}
}
