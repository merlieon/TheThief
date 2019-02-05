import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainView extends JFrame{
	public JTable table;
	Connection con;
	Statement statm;
	ResultSet rs;	
	
	int product_id;
	String product_type;
	String product_name;
	private JTextField txtFieldAddProduct;
	private JComboBox<String> comboBoxAddProduct;
	public MainView() throws SQLException {
		getContentPane().setEnabled(false);
		setTitle("Seach and Cook DB!");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 523);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(15, 50, 452, 437);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Product Id", "Product Name", "Product Type"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(527, 112, 137, 20);
		getContentPane().add(lblProductName);
		
		JLabel lblProductType = new JLabel("Product Type:");
		lblProductType.setBounds(527, 165, 137, 20);
		getContentPane().add(lblProductType);
		
		txtFieldAddProduct = new JTextField();
		txtFieldAddProduct.setBounds(649, 112, 220, 26);
		getContentPane().add(txtFieldAddProduct);
		txtFieldAddProduct.setColumns(10);
		
		comboBoxAddProduct = new JComboBox();
		comboBoxAddProduct.setBounds(649, 162, 220, 26);
		getContentPane().add(comboBoxAddProduct);
		
		JButton btnAddItem = new JButton("Add to database");
		btnAddItem.setBounds(722, 216, 147, 29);
		getContentPane().add(btnAddItem);

		btnAddItem.addActionListener((e) ->{
			try {
				addProducts();
				getLastProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		JButton btnDeleteItem = new JButton("Remove selected item");
		btnDeleteItem.setBounds(520, 216, 187, 29);
		getContentPane().add(btnDeleteItem);

		btnDeleteItem.addActionListener((e) -> {
			try {
				RemoveProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		con = DbUtil.getDbConnection();
	
		getProducts();
		getProductType();

	}	
	public void getProducts() {
		try {
			statm = con.createStatement();
			rs = statm.executeQuery("SELECT ingredients.id, ingredient, ingredient_type.ingredient_type, ingredients.ingredient_type, ingredient_type.ingredient_type_id  FROM ingredients, ingredient_type WHERE ingredients.ingredient_type = ingredient_type.ingredient_type_id ");

			while (rs.next()) {
				int numcols = table.getModel().getColumnCount();
				Object [] fill = new Object[numcols];
				product_id = rs.getInt("id");
				product_name = rs.getString("ingredient");
				product_type = rs.getString("ingredient_type");
					
				fill[0] = product_id;
				fill[1] = product_name;
				fill[2] = product_type;			
				((DefaultTableModel) table.getModel()).addRow(fill);

				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addProducts() throws SQLException {
		int productType = 0;
		if (comboBoxAddProduct.getSelectedItem().equals("Grönsak")) {
			productType = 1;
		} else if (comboBoxAddProduct.getSelectedItem().equals("Mejeri")) {
			productType = 2;
		} else if (comboBoxAddProduct.getSelectedItem().equals("Hushåll")) {
			productType = 3;
		} else {
			System.out.println("error");
		}
		
		statm = con.createStatement();
		String sqlInsert = "INSERT INTO ingredients (ingredient, ingredient_type) VALUES ('"+ txtFieldAddProduct.getText() +"', '"+productType+"')";
		statm.executeUpdate(sqlInsert);
		
		
	}
	
	public void getLastProduct() throws SQLException {
		rs = statm.executeQuery("SELECT ingredients.id, ingredient, ingredient_type.ingredient_type, ingredients.ingredient_type, ingredient_type.ingredient_type_id  FROM ingredients, ingredient_type WHERE ingredients.ingredient_type = ingredient_type.ingredient_type_id ");

		while (rs.last()) {
			int numcols = table.getModel().getColumnCount();
			Object [] fill = new Object[numcols];
			product_id = rs.getInt("id");
			product_name = rs.getString("ingredient");
			product_type = rs.getString("ingredient_type");
				
			fill[0] = product_id;
			fill[1] = product_name;
			fill[2] = product_type;			
			((DefaultTableModel) table.getModel()).addRow(fill);
			if (rs.isLast()) {
				break;
			}

		}
	}

	public void getProductType() throws SQLException {
		statm = con.createStatement();
	
		String sqlProdType = "SELECT ingredient_type FROM ingredient_type";
		rs = statm.executeQuery(sqlProdType);
		
		while (rs.next()) {
			String prodType = rs.getString("ingredient_type");
			comboBoxAddProduct.addItem(prodType);
		
	}
	
	}
	
	public void RemoveProduct() throws SQLException {
		int selectedRow = table.getSelectedRow();
		Object selectedItem = table.getValueAt(selectedRow, 0);
		String sqlDelete = "DELETE FROM `seachandcook`.`ingredients` WHERE (`id` = '"+ selectedItem +"');"; 
		statm = con.createStatement();
		statm.executeUpdate(sqlDelete);
		

		((DefaultTableModel) table.getModel()).removeRow(selectedRow);
	}
}
