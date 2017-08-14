import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class addFrame extends JFrame {

	private JPanel frameAdd;
	private JTextField fieldName;
	private JTextField fieldAddress;
	private JTextField fieldEmail;
	private JFormattedTextField formattedFieldBirth;
	private JFormattedTextField formattedFieldPhone;

	private JTextField fieldId;

	/**
	 * Launch the application.
	 */
	public static void addFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFrame frame = new addFrame();
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
	public addFrame() {
		setResizable(false);
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setTitle("Adicionar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 224);
		frameAdd = new JPanel();
		frameAdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frameAdd);
		frameAdd.setLayout(null);

		JLabel labelName = new JLabel("Nome*");
		labelName.setBounds(10, 11, 46, 14);
		frameAdd.add(labelName);

		fieldName = new JTextField();
		fieldName.setBounds(95, 8, 339, 20);
		frameAdd.add(fieldName);
		fieldName.setColumns(10);

		JLabel labelAddress = new JLabel("Endere\u00E7o*");
		labelAddress.setBounds(10, 61, 65, 14);
		frameAdd.add(labelAddress);

		fieldAddress = new JTextField();
		fieldAddress.setBounds(95, 58, 339, 20);
		frameAdd.add(fieldAddress);
		fieldAddress.setColumns(10);

		JLabel labelPhone = new JLabel("Telefone");
		labelPhone.setBounds(257, 36, 57, 14);
		frameAdd.add(labelPhone);

		JLabel labelBirth = new JLabel("Nascimento");
		labelBirth.setBounds(10, 36, 89, 14);
		frameAdd.add(labelBirth);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(10, 86, 46, 14);
		frameAdd.add(labelEmail);

		fieldEmail = new JTextField();
		fieldEmail.setBounds(95, 89, 339, 20);
		frameAdd.add(fieldEmail);
		fieldEmail.setColumns(10);

		formattedFieldBirth = new JFormattedTextField();
		try {
			MaskFormatter dateMask = new MaskFormatter("##/##/####");
			dateMask.install(formattedFieldBirth);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		formattedFieldBirth.setBounds(95, 33, 66, 20);
		frameAdd.add(formattedFieldBirth);

		formattedFieldPhone = new JFormattedTextField();
		try {
			MaskFormatter dateMask = new MaskFormatter("(##) #### ####");
			dateMask.install(formattedFieldPhone);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		formattedFieldPhone.setBounds(324, 33, 110, 20);
		frameAdd.add(formattedFieldPhone);

		JLabel labelId = new JLabel("ID");
		labelId.setBounds(171, 36, 11, 14);
		frameAdd.add(labelId);

		fieldId = new JTextField();
		fieldId.setEnabled(false);
		fieldId.setEditable(false);
		// fieldId.setText(Integer.toString(sequencia+1));
		fieldId.setBounds(187, 33, 60, 20);
		frameAdd.add(fieldId);
		fieldId.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fieldName.getText().equals("") || fieldAddress.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Campos com * sao obrigatórios!", "Mensagem",
							JOptionPane.ERROR_MESSAGE);
				else {
					boolean erro = false;

					if (!erro) {
						agendaClass ag = new agendaClass();

						ag = preencheAgenda(ag);

						AgendaDao dao = new AgendaDao();

						if (dao.insertAgenda(ag)) {
							limpaCampos();
							JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!", "Mensagem",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar Contato!", "Mensagem",
									JOptionPane.ERROR_MESSAGE);
						}

					}
					dispose();
				}

			}
		});
		btnSalvar.setBounds(72, 155, 89, 23);
		frameAdd.add(btnSalvar);

		JButton buttonBack = new JButton("Voltar");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		buttonBack.setBounds(303, 155, 89, 23);
		frameAdd.add(buttonBack);

	}

	private void limpaCampos() {
		fieldName.setText("");
		fieldAddress.setText("");
		fieldEmail.setText("");
		formattedFieldBirth.setText("");
		formattedFieldPhone.setText("");
	}

	private agendaClass preencheAgenda(agendaClass ag) {

		ag.setName(fieldName.getText());
		ag.setAddress(fieldAddress.getText());

		if (!fieldEmail.getText().equals(""))
			ag.setEmail(fieldEmail.getText());
		else
			ag.setEmail("");

		if (!formattedFieldPhone.getText().equals(""))
			ag.setPhone(formattedFieldPhone.getText());
		else
			ag.setPhone("");

		if (!formattedFieldBirth.getText().equals(""))
			ag.setBirth(formattedFieldBirth.getText());
		else
			ag.setBirth("");

		return ag;
	}

}
