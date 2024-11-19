package TareasCLI;

import java.util.ArrayList;
import java.util.List;

import TareasCLI.status.StatusTypo;

public class gestor {
	List<tareas> tasks = new ArrayList<tareas>();
	
	void addTask(String description) {
		tasks.add(taskFactory.crear(description));
	}
	
	void updateTask(String id, String description) {
		tareas currTask = findTask(id);
		currTask.update(description);
	}
	
	void deleteTask(String id) {
		tareas currTask = findTask(id);
		tasks.remove(currTask);
	}
	
	tareas findTask(String id) {
		return tasks.stream().filter(t -> t.id() == Integer.valueOf(id)).findAny().orElseThrow(() -> new IllegalArgumentException("No hay tarea con id " + id));
	}
	
	
	//Test
	List<tareas> tasks(){
		return tasks;
	}
	
	
	void showTasks() {
		for(tareas t : tasks) {
			String info = "ID: " + t.id() + " | Description: " + t.description + " | Status: " + t.status + 
					" | Created: " + t.createdDate() + " | LastUpdate: " + t.updateDate();
			System.out.println(info);
			
			for(int x = 0; x < info.length(); x++) {
				System.out.print("-");
			}
			System.out.print("\n");

		}
	}
	
	public static class taskFactory {
		public static tareas crear(String d) {
			return new tareas(d, StatusTypo.TODO);
		}
	}
	
}
