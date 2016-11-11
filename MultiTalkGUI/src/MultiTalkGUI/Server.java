/* @author bruno.casamassa*/


package MultiTalkGUI;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

import javax.swing.JOptionPane;

class ServerThread extends Thread {
	private Socket socket;
	private static Stack<Socket> sockets = new Stack<Socket>();
	private static Stack<String> nicks = new Stack<String>();
	private String nick;
	private InputStream istream;
	private InputStreamReader reader;
	private BufferedReader br;
	private OutputStream ostream;
	private PrintWriter pw;
	private boolean connect = false;
	private int contador = 15;
	public ServerThread(Socket socket) {
		try {
			this.socket = socket;

			istream = socket.getInputStream();
			reader = new InputStreamReader(istream);
			br = new BufferedReader(reader);
			ostream = socket.getOutputStream();
			pw = new PrintWriter(ostream , true);
			if(nicks.size() < 15 ){   //LIMITADOR DE CLIENTES
			pw.println("Nao Lotado");
			nick = br.readLine();	
			repasseMensagem(nick + " entrou na sala.");
			connect= true;
			start();
			sockets.push(socket);
			nicks.push(nick);
			}
			else{
				pw.println("Lotado");
				System.out.println("Servidor Lotado");
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while (connect) {
				repasse(socket);
				String msg = br.readLine();
				System.out.println(msg);
				if( msg.startsWith("/pvt") ){
					msg = msg.replaceFirst("/pvt ", "");
					String name = msg.substring(0 , msg.indexOf(" "));
					msg = msg.replaceFirst(name + " ", "");
					repassePrivado(name, msg);
				} else {
				repasseMensagem(nick + ": "+ msg);
				}
			}
		} catch (EOFException ie) {
		} catch (IOException ie) {
			
			try {
				repasseMensagem(nick + " saiu da sala.");
				nicks.remove(nick);
				sockets.remove(socket);
				connect = false;
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void repasseMensagem(String msg){
		for (Socket s : sockets) { //para todo socket 's' da pilha de sockets
			repasse(s);
			pw.println(msg);
		}
	}
	
	private void repassePrivado(String name, String msg) throws IOException {
//		if(nicks.contains(name))
		try{
		Socket s = sockets.get(nicks.indexOf(name));
		OutputStream ostream2 = s.getOutputStream();
		PrintWriter pw2 = new PrintWriter(ostream2 , true);
		pw2.println(nick + ": " + msg);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return;
		}
	}
	private void repasse(Socket s) {
		try {
			
			istream = s.getInputStream();
			ostream = s.getOutputStream();
			reader = new InputStreamReader(istream);
			br = new BufferedReader(reader);
			pw = new PrintWriter(ostream , true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class Server {

	private ServerSocket ss;
	private int i = 0;

	public Server(int port) throws IOException {
		ss = new ServerSocket(port);
		System.out.println("Aguardando conexão com cliente....");
		while (true) {
			Socket s = ss.accept();
			System.out.println("Obteve conexão de: " + s);
			new ServerThread(s);
		}

	}

	public static void main(String args[]) throws Exception {
		int port = 1234;
		new Server(port);

	}

}