import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AgendaMain extends JFrame {

	private JPanel mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaMain frame = new AgendaMain();
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
	public AgendaMain() {
		setResizable(false);
		setTitle("Agenda Telef\u00F4nica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 328);
		mainFrame = new JPanel();
		mainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainFrame);
		mainFrame.setLayout(null);

		JButton buttonAdd = new JButton("Adicionar");
		buttonAdd.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\trab poo\\iconAdd - Copy (2).png"));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addFrame add = new addFrame();
				add.addFrame();
			}
		});
		buttonAdd.setBounds(24, 35, 150, 41);
		mainFrame.add(buttonAdd);

		JButton buttonSearch = new JButton("Pesquisar");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// searchFrame search = new searchFrame();
				// search.searchFrame();
				SearchFrameClass search = new SearchFrameClass();
				search.SearchFrameClass();
			}
		});
		buttonSearch.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\trab poo\\active-search.png"));
		buttonSearch.setBounds(24, 87, 150, 41);
		mainFrame.add(buttonSearch);

		JButton buttonDelete = new JButton("Excluir");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = JOptionPane.showInputDialog("Entre com o ID do item para deletar");

				agendaClass ag = new agendaClass();
				AgendaDao dao = new AgendaDao();

				ag = dao.findById(Integer.parseInt(search));
				if (dao.deleteAgenda(ag)) {
					JOptionPane.showMessageDialog(null, "Contato deletado com sucesso!", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao deletar o Contato ou id inexistente", "Mensagem",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		buttonDelete.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\trab poo\\iconDelete.png"));
		buttonDelete.setBounds(24, 139, 150, 41);
		mainFrame.add(buttonDelete);

		JButton buttonExit = new JButton("Sair");
		buttonExit.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\trab poo\\iconExit.png"));
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		buttonExit.setBounds(24, 191, 150, 41);
		mainFrame.add(buttonExit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\trab poo\\phonebook-512 - Copy.png"));
		lblNewLabel.setBounds(229, 11, 292, 278);
		mainFrame.add(lblNewLabel);
	}
}
