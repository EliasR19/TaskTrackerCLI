package TareasCLI;
import java.util.Date;

import TareasCLI.status.*;

public class tareas {
	int id;
	static int idSiguiente = 1;
	String description;
	StatusTypo status;
	Date createdAt = new Date();
	Date updateAt;
	

	public tareas(String d, StatusTypo status) {
		// TODO Auto-generated constructor stub
		this.description = d;
		id = idSiguiente;
		idSiguiente++;
		this.status = status ;
	}
	
	public String description() {
		return description;
	}
	
	public int id() {
		return id;
	}
	
	public void update(String newDescription) {
		description = newDescription;
	}
	
	public StatusTypo status() {
		return status;
	}
	
	public void updateStatus(StatusTypo status) {
		this.status = status;
	}
	
}

