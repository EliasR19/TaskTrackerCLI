package TareasCLI;
import java.time.LocalDateTime;
import TareasCLI.status.StatusTypo;


import TareasCLI.status.StatusTypo;

public class tareas {
	private int id;
	private static int idSiguiente = 1;
	private String description;
	private StatusTypo status;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	

	public tareas(String d) {
		// TODO Auto-generated constructor stub
		this.description = d;
		id = idSiguiente;
		idSiguiente++;
		status = StatusTypo.TODO ;
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
	
	public static tareas fromJson(String taskJson) {
		taskJson = taskJson.replace("{", "").replace("}", "").replace("\"", "");
		String [] task1 = taskJson.split(",");		
		
		String idStr = task1[0].split(":")[1].strip();
		String statusStr = task1[1].split(":")[1].strip();
		String description = task1[2].split(":")[1].strip();	
		String createdAtStr = task1[3].split("[a-z]:")[1].strip();
		String updateAtStr = task1[4].split("[a-z]:")[1].strip();
		
		//System.out.println("tarea = " + idStr +" "+  description + " " + statusStr + " " + createdAtStr + " " + updateAtStr);
		
		StatusTypo statusT = StatusTypo.valueOf(statusStr);
		
		tareas newTask = new tareas(description);
		newTask.id = Integer.parseInt(idStr);
		newTask.description = description;
		newTask.status = statusT;
		newTask.createdAt = LocalDateTime.parse(createdAtStr);
		newTask.updateAt = LocalDateTime.parse(updateAtStr);
		
		if(Integer.parseInt(idStr) > idSiguiente) {
			idSiguiente = Integer.parseInt(idStr);
		}
		
		return newTask;
		
	}
	
	public String toJson() {
		return "{\"ID\":\"" + id + "\", \"Status\":\"" + status.toString() +  "\", \"Description\":\"" + description.strip() 
		+ "\", \"Created\":\"" + createdAt.toString() + "\", \"LastUpdate\":\"" + updateAt.toString() + "\"}";
	}
	
	void showTask() {
			String info = "ID: " + id() + " | Description: " + description + " | Status: " + status.toString() + 
					" | Created: " + createdDate().toString() + " | LastUpdate: " + updateDate().toString();
			System.out.println(info);
			
			for(int x = 0; x < info.length(); x++) {
				System.out.print("-");
			}
			System.out.print("\n");

		}
	
	
	
}


/*
 * 	{"id": "2", "description": "Comer", "status": "TODO",  "createdAt":"2024-11-19T09:42:29.810575100", "lastUpdate":"2024-11-19T09:42:29.810575100"},
	{"id": "3", "description": "Comer", "status": "TODO",  "createdAt":"2024-11-19T09:42:29.810575100", "lastUpdate":"2024-11-19T09:42:29.810575100"},
*/
 

