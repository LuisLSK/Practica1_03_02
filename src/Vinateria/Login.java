package Vinateria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	
	//Página principal

	public int abrir = 0;
	
	public JTextField jtxUsuario = new JTextField();
	public JPasswordField jtxPassword = new JPasswordField();
	
	public Login(){
		
		setTitle("Vinateria Rocío");
		setVisible(true);
		setSize(580,300);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		Log ();
		setVisible (true);
								
		JButton btnEntrar = new JButton();
		btnEntrar.setText("Entrar");
		add(btnEntrar);
		btnEntrar.setBounds(400, 210, 100, 30);
		btnEntrar.setToolTipText("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(32, 178, 170));
		btnEntrar.setBorder(new LineBorder(Color.WHITE,2));
				
		final JLabel jlbUsuario = new JLabel ("");
		jlbUsuario.setForeground(Color.WHITE);
		add(jlbUsuario);
		jlbUsuario.setText("Usuario:");
		jlbUsuario.setBounds(230, 50, 50, 20);
	
		JTextField jtxUsuario = new JTextField();
		jtxUsuario.setBounds(350, 50, 150, 20);
		jtxUsuario.setText("luisangel@login.es");
		add(jtxUsuario);
		jtxUsuario.setVisible(true);
		jtxUsuario.setToolTipText("Ingresa tu correo electrónico");
				
		final JLabel jlbContraseña = new JLabel ("");
		jlbContraseña.setForeground(Color.WHITE);
		add(jlbContraseña);
		jlbContraseña.setText("Contraseña:");
		jlbContraseña.setBounds(230, 130, 100, 20);
		
		final JPasswordField jtxPassword = new JPasswordField ();
		jtxPassword.setBounds(350, 130, 150, 20);
		jtxPassword.setText("luis123");
		super.add(jtxPassword);
		jtxPassword.setVisible(true);
		jtxPassword.setToolTipText("Ingresa tu contraseña");
	
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				String myLogin = jtxUsuario.getText().trim ();
				String myPass = new String (jtxPassword.getPassword()).trim();
				
				int siPass = verificapass(myLogin, myPass);
				
				if (siPass == 1){
					new Login().setVisible(false);
					dispose();
					abrir=0;
					new Menu().setVisible(true);
					abrir=1;
				}
			}
		});
}
	private void Log (){
		setLayout (null);
		
		final JPanel jpEncabezado = new JPanel(){
			protected void paintComponent(Graphics g)
			{
				Image imgIK = new ImageIcon(getClass().getResource("Res/Logo.png")).getImage();
				Dimension d = getSize ();
				g.drawImage (imgIK,0,0, d.width, d.height, null);
			}
		};
		jpEncabezado.setBounds(30, 60, 150,150);
		add(jpEncabezado);
	
	}
		final int caracter = 20;
		final int caracter2 = 5;
		private int verificapass(String login, String password){
			if (login.contains("@")){
			}else
				JOptionPane.showMessageDialog(null, "No hay un correo");
			if (password.length() <= caracter && password.length() >= caracter2){ 
			}else
				JOptionPane.showMessageDialog(null, "Tu correo o contraseña son incorrectos");
			if (login.equals("luisangel@login.es") && password.equals("luis123")){
				JOptionPane.showMessageDialog(null, "Bienvenido");
				return 1;
			}	return 0;
		}
		
		public static void main(String[] args) {
			
			new Login();
			//new Menu();
		}
		
}