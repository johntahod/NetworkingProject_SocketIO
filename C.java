import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("resource")
public class C {
	public static void main(String[] args) throws IOException {
		var socket = new Socket("localhost", 59090);
		var toServer = new PrintWriter(socket.getOutputStream(), true);
		var fromServer = new Scanner(socket.getInputStream() );
		
		System.out.println(fromServer.nextLine() ); System.out.println(fromServer.nextLine() );
		// Get the "got connection" + "server ready"
		
		Scanner in = new Scanner(System.in);
		String cmd = "", // User command. i.e. User input "UPPERCASE"
		s = "", x = ""; // s is the 400/200 . x is the follow-up input
//---------------------------------------------------------------------------------------------------
while (true) {
	System.out.print("c: ");
	cmd = in.nextLine(); toServer.println(cmd);
	// Get a command from user and send that to server
	s = fromServer.nextLine(); say(s);
	
	if (cmd.equals("EXIT") ) { System.exit(0) ; }
	else if (s.charAt(0) == '4') {} // If failed command, need to redo/loop back	
	else {
		while(!x.equals(".") ) {
			System.out.print("c: ");
			toServer.println(x);
			x = in.nextLine();
		}

		while(fromServer.hasNextLine() ) {
			say("s: " + fromServer.nextLine() );
		}
		
	}
}}//---------------------------------------------------------------------------------------------------
	private static void say(String s) { System.out.println(s); }
}