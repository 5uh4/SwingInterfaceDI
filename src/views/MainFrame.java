package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import models.Clients;
import models.Facturas;
import models.Products;

public class MainFrame {

	private JFrame frame;
	private JTextArea textAreaClientes;
	private JMenuItem altaCliente;
	private JButton btnClientes;
	private JTextPane textPane;
	private JButton btnUser;
	private JButton btnProductos;
	private JButton btnFacturas;
	private ArrayList<Clients> clientes;
	private ArrayList<Products> productos;
	private ArrayList<Facturas> facturas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Gestion de Clientes");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		setComponents();
		setBehaviours();
		crearClientesProdFact();
		frame.setVisible(true);
	}

	private void setComponents() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		ImageIcon imgLogo = new ImageIcon(System.getProperty("user.dir") + "/assets/picassoLogo.png");
		JLabel lblLogoImg = new JLabel(imgLogo);
		topPanel.add(lblLogoImg);

		JLabel lblPicasso = new JLabel("I.E.S. PABLO PICASSO ");
		topPanel.add(lblPicasso);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] { 191, 0 };
		gbl_leftPanel.rowHeights = new int[] { 98, 80, 92, 106, 0 };
		gbl_leftPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_leftPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		leftPanel.setLayout(gbl_leftPanel);

		ImageIcon imgClientes = new ImageIcon(System.getProperty("user.dir") + "/assets/clientes.png");
		btnClientes = new JButton("Clientes");
		btnClientes.setIcon(imgClientes);
		btnClientes.setIconTextGap(5);
		btnClientes.setBackground(Color.BLUE);
		btnClientes.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.fill = GridBagConstraints.BOTH;
		gbc_btnClientes.insets = new Insets(0, 0, 5, 0);
		gbc_btnClientes.gridx = 0;
		gbc_btnClientes.gridy = 0;
		leftPanel.add(btnClientes, gbc_btnClientes);

		ImageIcon imgProductos = new ImageIcon(System.getProperty("user.dir") + "/assets/productos.png");
		btnProductos = new JButton("Productos");
		btnProductos.setIcon(imgProductos);
		btnProductos.setIconTextGap(5);
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnProductos = new GridBagConstraints();
		gbc_btnProductos.fill = GridBagConstraints.BOTH;
		gbc_btnProductos.insets = new Insets(0, 0, 5, 0);
		gbc_btnProductos.gridx = 0;
		gbc_btnProductos.gridy = 1;
		leftPanel.add(btnProductos, gbc_btnProductos);

		btnFacturas = new JButton("Facturas");
		ImageIcon imgFacturas = new ImageIcon(System.getProperty("user.dir") + "/assets/facturas.jpg");
		btnFacturas.setIcon(imgFacturas);
		btnFacturas.setIconTextGap(5);
		btnFacturas.setForeground(Color.WHITE);
		btnFacturas.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnFacturas = new GridBagConstraints();
		gbc_btnFacturas.fill = GridBagConstraints.BOTH;
		gbc_btnFacturas.insets = new Insets(0, 0, 5, 0);
		gbc_btnFacturas.gridx = 0;
		gbc_btnFacturas.gridy = 2;
		leftPanel.add(btnFacturas, gbc_btnFacturas);

		btnUser = new JButton("Usuario");
		ImageIcon imgUser = new ImageIcon(System.getProperty("user.dir") + "/assets/user-removebg-preview.png");
		btnUser.setIcon(imgUser);
		btnUser.setIconTextGap(10);
		btnUser.setVerticalTextPosition(SwingConstants.BOTTOM);
//		JLabel lblUser = new JLabel(imgUser);
//		btnUser.add(lblUser);
		btnUser.setForeground(Color.WHITE);
		btnUser.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnUser = new GridBagConstraints();
		gbc_btnUser.fill = GridBagConstraints.BOTH;
		gbc_btnUser.gridx = 0;
		gbc_btnUser.gridy = 3;
		leftPanel.add(btnUser, gbc_btnUser);

		textPane = new JTextPane();
		textPane.setBackground(new Color(0, 206, 209));
		frame.getContentPane().add(textPane, BorderLayout.CENTER);

		JLabel lblSuhail = new JLabel("Suhail Matrouch Mohamed");
		lblSuhail.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSuhail, BorderLayout.SOUTH);
	}

	private void setBehaviours() {

		btnFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFacturas();
			}

			private void showFacturas() {
				StringBuilder sb = new StringBuilder("");
				for (Facturas fr : facturas) {
					sb.append(fr.toString()).append("\n");
				}
				textPane.setText(sb.toString());
			}
		});

		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showProductos();
			}

			private void showProductos() {
				StringBuilder sb = new StringBuilder("");
				for (Products pr : productos) {
					sb.append(pr.toString()).append("\n");
				}
				textPane.setText(sb.toString());
			}
		});

		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				displayAlta();
				showClientes();
			}

			private void showClientes() {
				StringBuilder sb = new StringBuilder();
				for (Clients cl : clientes) {
					sb.append(cl.toString()).append("\n");
				}
				textPane.setText(sb.toString());

			};

//			private void displayAlta() {
//				String[] provincias = { "Malaga", "Madrid", "Cadiz", "Barcelona", "Valencia" };
//				JComboBox<String> comboProvincia = new JComboBox<>(provincias);
//				JTextField nombreCliente = new JTextField("");
//				JTextField apellidoCliente = new JTextField("");
//				JTextField edadCliente = new JTextField("");
//				JPanel panel = new JPanel(new GridLayout(0, 1));
//				panel.add(new JLabel("Nombre del Cliente:"));
//				panel.add(nombreCliente);
//				panel.add(new JLabel("Apellido del cliente:"));
//				panel.add(apellidoCliente);
//				panel.add(new JLabel("Edad del cliente"));
//				panel.add(edadCliente);
//				panel.add(new JLabel("Provincia del cliente: "));
//				panel.add(comboProvincia);
//				int result = JOptionPane.showConfirmDialog(altaCliente, panel, "Alta Cliente",
//						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//				if (result == JOptionPane.OK_OPTION) {
//					Clients clienteNuevo = new Clients(nombreCliente.getText(), apellidoCliente.getText(),
//							Integer.parseInt(edadCliente.getText()), comboProvincia.getSelectedItem().toString());
//					clientes.add(clienteNuevo);
//					textAreaClientes.setText(clientes.toString());
//				} else {
//					JOptionPane.showMessageDialog(altaCliente, "No se ha creado el cliente.");
//				}
//			}

		});

	}

	private void crearClientesProdFact() {
		clientes = new ArrayList<Clients>();
		Clients client1 = new Clients("Manolo", "Bombacho", 25, "Málaga");
		Clients client2 = new Clients("Jose", "Garcia", 42, "Madrid");
		clientes.add(client1);
		clientes.add(client2);

		productos = new ArrayList<Products>();
		Products producto1 = new Products("Cyberpunk 2077", 59.99, false);
		Products producto2 = new Products("Suicide Squad - Kill the Justice League", 79.99, false);
		Products producto3 = new Products("League Of Legends", 0.0, false);
		productos.add(producto1);
		productos.add(producto2);

		ArrayList<Products> productos2 = new ArrayList<>();
		productos2.add(producto1);
		productos2.add(producto3);

		facturas = new ArrayList<Facturas>();
		Facturas fac1 = new Facturas("02", client2, productos);
		Facturas fac2 = new Facturas("04", client1, productos2);
		facturas.add(fac1);
		facturas.add(fac2);
	}
}
