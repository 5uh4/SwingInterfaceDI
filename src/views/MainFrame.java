package views;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Clients;
import models.Products;

public class MainFrame {

	private JFrame frame;
	private JTextArea textAreaClientes;
	private JMenuBar menuBar;
	private JMenu MenuClientes;
	private JMenuItem altaCliente;
	private JMenuItem bajaCliente;
	private JMenu MenuProductos;
	private JMenuItem altaProductos;
	private JMenuItem listarProductos;
	private JTextArea areaLista;
	private ArrayList<Clients> clientes;
	private ArrayList<Products> productos;
	private JComboBox<Clients> comboClientes;

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
		crearClientesProd();
		setComponents();
		setBehaviours();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

	}

	private void setComponents() {

		textAreaClientes = new JTextArea();
		textAreaClientes.setBounds(10, 49, 523, 248);
		textAreaClientes.setVisible(true);
		frame.getContentPane().add(textAreaClientes);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 543, 22);
		frame.getContentPane().add(menuBar);

		MenuClientes = new JMenu("Menu de Clientes");
		MenuClientes.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(MenuClientes);

		altaCliente = new JMenuItem("Alta cliente");
		MenuClientes.add(altaCliente);

		bajaCliente = new JMenuItem("Baja Cliente");
		MenuClientes.add(bajaCliente);

		MenuProductos = new JMenu("Menu de Productos");
		MenuProductos.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(MenuProductos);

		altaProductos = new JMenuItem("Alta productos");
		MenuProductos.add(altaProductos);

		listarProductos = new JMenuItem("Lista de Productos");
		MenuProductos.add(listarProductos);
		textAreaClientes.setText(clientes.toString());
	}

	private void setBehaviours() {

		altaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayAlta();
			}

			private void displayAlta() {
				String[] provincias = { "Malaga", "Madrid", "Cadiz", "Barcelona", "Valencia" };
				JComboBox<String> comboProvincia = new JComboBox<>(provincias);
				JTextField nombreCliente = new JTextField("");
				JTextField apellidoCliente = new JTextField("");
				JTextField edadCliente = new JTextField("");
				JPanel panel = new JPanel(new GridLayout(0, 1));
				panel.add(new JLabel("Nombre del Cliente:"));
				panel.add(nombreCliente);
				panel.add(new JLabel("Apellido del cliente:"));
				panel.add(apellidoCliente);
				panel.add(new JLabel("Edad del cliente"));
				panel.add(edadCliente);
				panel.add(new JLabel("Provincia del cliente: "));
				panel.add(comboProvincia);
				int result = JOptionPane.showConfirmDialog(altaCliente, panel, "Alta Cliente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					Clients clienteNuevo = new Clients(nombreCliente.getText(), apellidoCliente.getText(),
							Integer.parseInt(edadCliente.getText()), comboProvincia.getSelectedItem().toString());
					clientes.add(clienteNuevo);
					textAreaClientes.setText(clientes.toString());
				} else {
					JOptionPane.showMessageDialog(altaCliente, "No se ha creado el cliente.");
				}
			}
		});

		bajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayBaja();
			}

			private void displayBaja() {
				comboClientes = new JComboBox<>();
				JPanel panel = new JPanel(new GridLayout(0, 1));
				panel.add(new JLabel("Elegir cliente que borrar"));
				for (Clients cliente : clientes) {
					comboClientes.addItem(cliente);
				}
				panel.add(comboClientes);
				int result = JOptionPane.showConfirmDialog(bajaCliente, panel, "Baja cliente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					Clients selectedCliente = (Clients) comboClientes.getSelectedItem();
					clientes.remove(selectedCliente);
					textAreaClientes.setText(clientes.toString());
				} else {
					JOptionPane.showMessageDialog(bajaCliente, "No se ha dado de baja ningun cliente");
				}
			}
		});

		altaProductos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				displayAltaProd();
			}

			private void displayAltaProd() {
				String[] perecedero = { "Verdadero", "Falso" };
				JComboBox<String> comboPerecedero = new JComboBox<>(perecedero);
				JTextField nombreProd = new JTextField("");
				JTextField precioUnitario = new JTextField("");
				JPanel panel = new JPanel(new GridLayout(0, 1));
				panel.add(new JLabel("Nombre del producto:"));
				panel.add(nombreProd);
				panel.add(new JLabel("Precio del producto"));
				panel.add(precioUnitario);
				panel.add(new JLabel("Es perecedero: "));
				panel.add(comboPerecedero);
				int result = JOptionPane.showConfirmDialog(altaCliente, panel, "Alta Cliente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					if(comboPerecedero.getSelectedItem() == "Verdadero") {
						Products productoNuevo = new Products(nombreProd.getText(),
								Double.parseDouble(precioUnitario.getText()), true);
						productos.add(productoNuevo);
					} else {
						Products productoNuevo = new Products(nombreProd.getText(),
								Double.parseDouble(precioUnitario.getText()), false);
						productos.add(productoNuevo);						
					}
				} else {
					JOptionPane.showMessageDialog(altaCliente, "No se ha creado el producto.");
				}
			}
		});

		listarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayListaProd();
			}

			private void displayListaProd() {
				areaLista = new JTextArea();
				areaLista.setText(productos.toString());
				JPanel panel = new JPanel(new GridLayout(0, 1));
				panel.add(areaLista);
				JOptionPane.showMessageDialog(frame, panel, "Lista de Productos", JOptionPane.PLAIN_MESSAGE);
			}
		});

	}

	private void crearClientesProd() {
		clientes = new ArrayList<Clients>();
		Clients client1 = new Clients("Manolo", "Bombacho", 25, "Málaga");
		Clients client2 = new Clients("Jose", "Garcia", 42, "Madrid");
		clientes.add(client1);
		clientes.add(client2);

		productos = new ArrayList<Products>();
		Products producto1 = new Products("Cyberpunk 2077", 59.99, false);
		productos.add(producto1);
	}
}
