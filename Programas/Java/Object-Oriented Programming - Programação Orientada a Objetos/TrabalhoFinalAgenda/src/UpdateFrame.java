import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fieldName;
	private JTextField fieldAddress;
	private JTextField fieldEmail;
	private JFormattedTextField formattedFieldBirth;
	private JFormattedTextField formattedFieldPhone;
	private JLabel labelId;
	private JTextField fieldId;
	private JButton buttonUpdate;
	private JButton buttonBack;
	private JButton btnProcurar;

	private String search;

	/**
	 * Launch the application.
	 */
	public static void UpdateFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
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
	public UpdateFrame() {
		setTitle("Atualizar Contato");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 461, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
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
		fieldId.setEditable(false);
		fieldId.setEnabled(false);
		fieldId.setBounds(193, 33, 67, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);

		buttonUpdate = new JButton("Atualizar");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendaClass ag = new agendaClass();
				ag = atualizaAgenda(ag);

				AgendaDao dao = new AgendaDao();

				if (dao.updateAgenda(ag))
					JOptionPane.showMessageDialog(new JFrame(), "Atualizado com sucesso!");
				else
					JOptionPane.showMessageDialog(new JFrame(), "Erro ao atualizar!");

				limpaCampos();
				dispose();
				//

			}
		});
		buttonUpdate.setBounds(40, 144, 89, 23);
		contentPane.add(buttonUpdate);

		buttonBack = new JButton("Voltar");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonBack.setBounds(327, 144, 89, 23);
		contentPane.add(buttonBack);

		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search = JOptionPane.showInputDialog("Enter the ID");

				agendaClass ag = new agendaClass();
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				limpaCampos();
				preencheAgenda(ag);
			}
		});
		btnProcurar.setBounds(180, 144, 89, 23);
		contentPane.add(btnProcurar);
	}

	public void preencheAgenda(agendaClass ag) {

		fieldId.setText(String.valueOf(ag.getId()));

		fieldName.setText(ag.getName());
		fieldAddress.setText(ag.getAddress());
		fieldEmail.setText(ag.getEmail());
		formattedFieldBirth.setText(ag.getBirth());
		formattedFieldPhone.setText(ag.getPhone());

	}

	public agendaClass atualizaAgenda(agendaClass ag) {

		ag.setName(fieldName.getText());
		ag.setAddress(fieldAddress.getText());
		ag.setEmail(fieldEmail.getText());
		ag.setBirth(formattedFieldBirth.getText());
		ag.setPhone(formattedFieldPhone.getText());
		ag.setId(Integer.parseInt(fieldId.getText()));

		// System.out.println(fieldName.getName());

		return ag;

	}

	private void limpaCampos() {
		fieldName.setText("");
		fieldAddress.setText("");
		fieldEmail.setText("");
		formattedFieldBirth.setText("");
		formattedFieldPhone.setText("");
	}

}
