
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListarTodosModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<agendaClass> agenda;
	
	private String[] colNomes = {"ID", "Nome", "Telefone"};
	private Class<?>[] colTipos = {Integer.class, String.class, String.class};
	
	public ListarTodosModel() {
	}
	
	public void reload(List<agendaClass> agenda) {
		this.agenda = agenda;
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return colTipos[coluna];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int coluna) {
		return colNomes[coluna];
	}

	@Override
	public int getRowCount() {
		if (agenda == null){
			return 0;
		}
		return agenda.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		agendaClass ag = agenda.get(linha);
		switch (coluna) {
		case 0:
			return ag.getId();
		case 1:
			return ag.getName();
		case 2:
			return ag.getPhone();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public agendaClass getAgendaAt(int index) {
		return agenda.get(index);
	}
}