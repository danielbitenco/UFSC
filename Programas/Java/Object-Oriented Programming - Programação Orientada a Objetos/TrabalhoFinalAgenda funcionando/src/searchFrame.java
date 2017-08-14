import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class searchFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void searchFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchFrame frame = new searchFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel frameAdd;
	private JTextField fieldName;
	private JTextField fieldAddress;
	private JTextField fieldEmail;
	private JFormattedTextField formattedFieldBirth;
	private JFormattedTextField formattedFieldPhone;
	private JLabel labelId;
	private JTextField fieldId;
	private JButton buttonSearch;
	private JButton buttonExit;
	private JButton butonNext;
	private JButton buttonPrevious;
	
//	private ListarTodos table; 
	private String search;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public searchFrame() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("Nome");
		labelName.setBounds(10, 11, 46, 14);
		contentPane.add(labelName);
		
		fieldName = new JTextField();
		fieldName.setBounds(95, 8, 339, 20);
		contentPane.add(fieldName);
		fieldName.setColumns(10);
		
		JLabel labelAddress = new JLabel("Endere\u00E7o");
		labelAddress.setBounds(10, 61, 65, 14);
		contentPane.add(labelAddress);
		
		fieldAddress = new JTextField();
		fieldAddress.setBounds(95, 58, 339, 20);
		contentPane.add(fieldAddress);
		fieldAddress.setColumns(10);
		
		JLabel labelPhone = new JLabel("Telefone");
		labelPhone.setBounds(269, 36, 65, 14);
		contentPane.add(labelPhone);
		
		JLabel labelBirth = new JLabel("Nascimento");
		labelBirth.setBounds(10, 36, 89, 14);
		contentPane.add(labelBirth);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(10, 86, 46, 14);
		contentPane.add(labelEmail);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(95, 89, 339, 20);
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		formattedFieldBirth = new JFormattedTextField();
		formattedFieldBirth.setBounds(95, 33, 66, 20);
		 try {
				MaskFormatter dateMask = new MaskFormatter("##/##/####");
				dateMask.install(formattedFieldBirth);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		contentPane.add(formattedFieldBirth);
		
		formattedFieldPhone = new JFormattedTextField();
		formattedFieldPhone.setBounds(331, 33, 103, 20);
		 try {
				MaskFormatter dateMask = new MaskFormatter("(##) #### ####");
				dateMask.install(formattedFieldPhone);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		contentPane.add(formattedFieldPhone);
		
		labelId = new JLabel("ID");
		labelId.setBounds(180, 36, 16, 14);
		contentPane.add(labelId);
		
		fieldId = new JTextField();
		fieldId.setBounds(193, 33, 67, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		buttonSearch = new JButton("Localiza por ID");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search = JOptionPane.showInputDialog("Enter the ID");
	
				
				agendaClass ag = new agendaClass();	
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				limpaCampos();
				preencheAgenda(ag);		
				
				
			}
		});
		buttonSearch.setBounds(10, 147, 123, 23);
		contentPane.add(buttonSearch);
		
		buttonExit = new JButton("Sair");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonExit.setBounds(295, 205, 123, 23);
		contentPane.add(buttonExit);
		
		butonNext = new JButton("Proximo");
		butonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux;
				aux = Integer.parseInt(search);
				aux++;
				search = String.valueOf(aux);
				
				agendaClass ag = new agendaClass();	
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				limpaCampos();
				preencheAgenda(ag);		
				
				
				
			}
		});
		butonNext.setBounds(156, 205, 123, 23);
		contentPane.add(butonNext);
		
		buttonPrevious = new JButton("Anterior");
		buttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux;
				aux = Integer.parseInt(search);
				aux--;
				search = String.valueOf(aux);
				
				agendaClass ag = new agendaClass();	
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				limpaCampos();
				preencheAgenda(ag);		
				
				
			}
		});
		buttonPrevious.setBounds(10, 205, 123, 23);
		contentPane.add(buttonPrevious);
		
		JButton buttonList = new JButton("Listar todos");
		buttonList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableFrame sf = new TableFrame();
				sf.TableFrame();
			}
		});
		buttonList.setBounds(295, 147, 123, 23);
		contentPane.add(buttonList);

		
	}
	public void preencheAgenda(agendaClass ag) {
		
		fieldId.setText(String.valueOf(ag.getId()));
		
		fieldName.setText(ag.getName());
		fieldAddress.setText(ag.getAddress());
		fieldEmail.setText(ag.getEmail());
		formattedFieldBirth.setText(ag.getBirth());
		formattedFieldPhone.setText(ag.getPhone());
		
				
	}
	
	private void limpaCampos() {
		fieldName.setText("");
		fieldAddress.setText("");
		fieldEmail.setText("");
		formattedFieldBirth.setText("");
		formattedFieldPhone.setText("");
	}
}
