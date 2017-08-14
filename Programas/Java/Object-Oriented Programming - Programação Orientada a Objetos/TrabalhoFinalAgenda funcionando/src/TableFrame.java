import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;


public class TableFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private ListarTodos tabela;


	/**
	 * Launch the application.
	 */
	public static void TableFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrame frame = new TableFrame();
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
	public TableFrame() {
		setTitle("Lista de todos os contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 414, 239);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		add(scrollPane);

	}
	
	
		
	public Runnable newAtualizaAgendaAction() {
		return new Runnable() {
			public void run() {
				try {
					AgendaDao dao = new AgendaDao();
					tabela.reload(dao.list());
				} catch (PersistenceException ex) {
					
				}
			}
		};
	}	
}


