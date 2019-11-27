import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

@SuppressWarnings("resource")
public class S {
	public static void main(String[] args) throws IOException {
		try (var listener = new ServerSocket(59090) ) {
			System.out.println("The server is running...");
			while (true) {
				try (var socket = listener.accept() ) {
					var toClient = new PrintWriter(socket.getOutputStream(), true);
					var fromClient = new Scanner(socket.getInputStream() );
					String ip = socket.getInetAddress().getHostAddress();
					toClient.println("server: got connection from client " + ip);
					toClient.println("Server is ready...");
//---------------------------------------------------------------------------------------------------
while(true) {
	boolean ok = true; String s = "";
	String cmd = fromClient.nextLine();
	if (cmd.equals("UPPERCASE") || cmd.equals("LOWERCASE") || cmd.equals("REVERSE") || cmd.equals("EXIT") ) {
		toClient.println("200 OK");
		say(ip + " sends " + cmd);
	}
	else {
		toClient.println("400: Not a valid command!");
		say(ip + " sends " + "dinvalid!"); ok = false;
	}
	
	if (cmd.equals("EXIT") ) { System.exit(0) ; }
	else if (!ok) {} // If failed command, need to redo/loop back	
	else { fromClient.nextLine().toString();
		while ( !s.equals(".") ) {
			s = fromClient.nextLine().toString(); say(s);
			if (cmd.equals("UPPERCASE") ) { toClient.println(s.toUpperCase() ); }
			else if (cmd.equals("LOWERCASE") ) { toClient.println(s.toLowerCase() ); }
			else { toClient.println( reverse(s) ); }
		}
	}
}

}}}}
//---------------------------------------------------------------------------------------------------
	private static String reverse(String line) {
		String s = "";
		for (int i = line.length() - 1 ; i >= 0 ; i--) {
			s += line.charAt(i);
		} return s;
	}
	
	private static void say(String s) { System.out.println(s); }
}
