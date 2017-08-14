import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class SearchFrameClass extends JFrame {

	private JPanel contentPane;

	private JPanel frameAdd;
	private JTextField fieldName;
	private JTextField fieldAddress;
	private JTextField fieldEmail;
	private JFormattedTextField formattedFieldBirth;
	private JFormattedTextField formattedFieldPhone;
	private JLabel labelId;
	private JTextField fieldId;
	private JButton buttonSearch;
	private JButton buttonBack;
	private JButton butonNext;
	private JButton buttonPrevious;

	private String search;
	private JTable table;

	private ArrayList<Integer> listId = new ArrayList<Integer>();
	private int aux = 0;
	private int max = 0;
	private JButton buttonUpdate;

	/**
	 * Launch the application.
	 */
	public static void SearchFrameClass() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrameClass frame = new SearchFrameClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchFrameClass() {
		setTitle("Pesquisar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 461, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AgendaDao dao = new AgendaDao();
		listId = dao.findJustIds();
		max = listId.size();

		JLabel labelName = new JLabel("Nome");
		labelName.setBounds(10, 11, 46, 14);
		contentPane.add(labelName);

		fieldName = new JTextField();
		fieldName.setEditable(false);
		fieldName.setBounds(95, 8, 339, 20);
		contentPane.add(fieldName);
		fieldName.setColumns(10);

		JLabel labelAddress = new JLabel("Endere\u00E7o");
		labelAddress.setBounds(10, 61, 65, 14);
		contentPane.add(labelAddress);

		fieldAddress = new JTextField();
		fieldAddress.setEditable(false);
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
		fieldEmail.setEditable(false);
		fieldEmail.setBounds(95, 89, 339, 20);
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);

		formattedFieldBirth = new JFormattedTextField();
		formattedFieldBirth.setEditable(false);
		formattedFieldBirth.setBounds(95, 33, 66, 20);
		try {
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
			dateMask.install(formattedFieldBirth);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		contentPane.add(formattedFieldBirth);

		formattedFieldPhone = new JFormattedTextField();
		formattedFieldPhone.setEditable(false);
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
		fieldId.setEditable(false);
		fieldId.setBounds(193, 33, 67, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);

		agendaClass aG = new agendaClass();
		aG = dao.findById(listId.get(0));
		preencheAgenda(aG);

		buttonSearch = new JButton("Localiza por ID");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search = JOptionPane.showInputDialog("Enter the ID");
				aux = Integer.parseInt(search);

				agendaClass ag = new agendaClass();
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				limpaCampos();
				preencheAgenda(ag);

			}
		});
		buttonSearch.setBounds(10, 147, 123, 23);
		contentPane.add(buttonSearch);

		buttonBack = new JButton("Voltar");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonBack.setBounds(295, 205, 123, 23);
		contentPane.add(buttonBack);

		butonNext = new JButton("Proximo");
		butonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agendaClass ag = new agendaClass();
				AgendaDao dao = new AgendaDao();
				aux++;

				if (aux < max) {
					ag = dao.findById(listId.get(aux));
					limpaCampos();
					preencheAgenda(ag);

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Nao exite mais contatos proximos");
					aux--;
				}

			}
		});
		butonNext.setBounds(156, 205, 123, 23);
		contentPane.add(butonNext);

		buttonPrevious = new JButton("Anterior");
		buttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				agendaClass ag = new agendaClass();
				AgendaDao dao = new AgendaDao();
				aux--;

				if (aux >= 0) {
					ag = dao.findById(listId.get(aux));
					limpaCampos();
					preencheAgenda(ag);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Nao exite mais contatos anteriores");
					aux++;
				}
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

		buttonUpdate = new JButton("Atualizar por ID");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateFrame uf = new UpdateFrame();
				uf.UpdateFrame();

			}
		});
		buttonUpdate.setBounds(156, 147, 123, 23);
		contentPane.add(buttonUpdate);

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
