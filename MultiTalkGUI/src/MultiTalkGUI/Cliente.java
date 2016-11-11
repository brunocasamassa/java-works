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
import java.net.Socket;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame implements Runnable {

	private Socket s;
	private int i = 0;
	private JTextField envio;
	private JTextArea usuarios;
	private JTextArea mensagens;
	private InputStream istream ;
	private InputStreamReader reader;
	private BufferedReader br;
	private OutputStream ostream;
	private PrintWriter pw;
	private Thread thread;
	private String nick;
	
	
	public Cliente(int port) throws IOException {
	
		s = new Socket("localhost", port);

		istream = s.getInputStream();
		reader = new InputStreamReader(istream);
		br = new BufferedReader(reader);
		ostream = s.getOutputStream();
		pw = new PrintWriter(ostream , true);
		
		String login = br.readLine();
		if(login.contentEquals("Lotado")){
			 JOptionPane.showMessageDialog(null,"LOTADO");
			 s.close();
			 System.exit(0);
			 return;
		}
		System.out.println("Aguardando conexão com Servidor....");
		System.out.println("Obteve conexão de: " + s);

		nick = JOptionPane.showInputDialog("Digite um apelido");
		
		
		this.setSize(400, 300);
		getContentPane().setLayout(null);

		envio = new JTextField();
		envio.setBounds(10, 236, 284, 28);
		getContentPane().add(envio);
		envio.setColumns(10);

		mensagens = new JTextArea();
		mensagens.setBounds(10, 11, 284, 212);
		getContentPane().add(mensagens);

		usuarios = new JTextArea();
		usuarios.setBounds(304, 11, 82, 212);
		getContentPane().add(usuarios);
		adicionaUsuario(nick);
		
		
		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enviarMensagem();
			}
		});
		enviar.setBounds(304, 239, 82, 23);
		getContentPane().add(enviar);
		
		pw.println(nick);
		
		thread = new Thread(this, "Client - " + nick);
		thread.start();
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(nick);
		this.setFocusable(true);
	}

	private void enviarMensagem(){
		pw.println(envio.getText());
		envio.setText("");
	}
	
	private void adicionaUsuario(String nick){
		usuarios.append(nick.trim()+ "\n");
		
	}
	
	private void imprimeTela(String msg){
		mensagens.append(msg.trim()+ "\n");
		
	}
	
	public static void main(String args[]) throws Exception {
		int port = 1234;
		new Cliente(port);
	}

	
	@Override
	public void run() {
		while (true) {
			try {
				String msg = br.readLine();
				imprimeTela(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
