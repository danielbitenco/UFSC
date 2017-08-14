import java.util.List;

import javax.swing.JTable;

public class ListarTodos extends JTable {

	private static final long serialVersionUID = 1L;
	private ListarTodosModel modelo;
	
	public ListarTodos() {
		modelo = new ListarTodosModel();
		setModel(modelo);
	}
	
	public agendaClass getAgendaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getAgendaAt(i);
	}
	
	public void reload(List<agendaClass> agenda) {
		modelo.reload(agenda);
	}
}