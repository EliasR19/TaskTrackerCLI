package TareasCLI;
import java.time.LocalDateTime;

import TareasCLI.status.*;

public class tareas {
	int id;
	static int idSiguiente = 1;
	String description;
	StatusTypo status;
	LocalDateTime createdAt;
	LocalDateTime updateAt;
	

	public tareas(String d, StatusTypo status) {
		// TODO Auto-generated constructor stub
		this.description = d;
		id = idSiguiente;
		idSiguiente++;
		this.status = status ;
		createdAt = LocalDateTime.now();
		updateAt = LocalDateTime.now();
	}
	
	public String description() {
		return description;
	}
	
	public int id() {
		return id;
	}
	
	public void update(String newDescription) {
		description = newDescription;
		updateAt = LocalDateTime.now();
	}
	
	public StatusTypo status() {
		return status;
	}
	
	public void updateStatus(StatusTypo status) {
		this.status = status;
	}
	
	LocalDateTime createdDate() {
		return createdAt;
	}
	
	LocalDateTime updateDate() {
		return updateAt;
	}
	
	
	
}

