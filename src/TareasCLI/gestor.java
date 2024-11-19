package TareasCLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import TareasCLI.status.StatusTypo;


public class gestor {
	List<tareas> tasks = new ArrayList<tareas>();
	Path path = Path.of("tasks.text");
	
	//Constructor, cuando se inicializa la clase llama a loadTask() y agarra la lista de tareas del archivo;
	
	public gestor() {
		tasks = loadTask();
	}
	
	
	
	// Cargar las tareas guardadas del archivo
	public List<tareas> loadTask() {
		List<tareas> loadT = new ArrayList<>();
	
		if(!Files.exists(path)) {
			//System.out.println("No existe");
			return new ArrayList<>();
		}
		
		try {
			String content = Files.readString(path);		
			String[]  taskList = content.replace("[", "").replace("]", "").split("},");
						
			for(String t : taskList) {
					loadT.add(tareas.fromJson(t));
				
					
				
				
			
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loadT;
	}
	

	
	/*Construir un string
	 * - emepiza por \n
	 * por cada tarea de la lista convertilo a json
	 * */
	public void saveTasks() {
		StringBuilder string = new StringBuilder();
		string.append("[\n");
		
		for(tareas task : tasks) {
			string.append(task.toJson());
			if(task == tasks.getLast()) {
				string.append("\n");
			} else {
				string.append(",\n");
			}
		}
		
		string.append("]");
		
		//System.out.println(string);
		
		try {
			Files.writeString(path, string.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	void addTask(String description) {
		tasks.add(new tareas(description));
	}
	
	void updateTask(String id, String description) {
		tareas currTask = findTask(id);
		currTask.update(description);
	}
	
	void removeTask(String id) {
		tareas currTask = findTask(id);
		tasks.remove(currTask);
	}
	
	void removeAll() {
		tasks.removeAll(tasks);
	}
	
	void updateStatus(StatusTypo statusNew, String id) {
		tareas currTask = findTask(id);
		currTask.updateStatus(statusNew);
	}
	
	
	
	
	tareas findTask(String id) {
		return tasks.stream().filter(t -> t.id() == Integer.valueOf(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("No hay tarea con id " + id));
	}
	
	
	
	List<tareas> tasks(){
		return tasks;
	}
	
	public void showTasks(String args) {
		if(args.equals("all")) {	
				showList(tasks);		
		} else {
				showList(showStatus(args));	
		}
	}
	
	public List<tareas> showStatus(String status) {
		StatusTypo statusShow= StatusTypo.valueOf(status.toUpperCase().replace("-", "_"));
		return tasks.stream().filter(t -> t.is(statusShow)).collect(Collectors.toList());
	}
	
	public void showList(List<tareas> listTasks) {
		for(tareas t : listTasks) {
			System.out.println(t.showTask());
			makeTable(t.showTask());
		}
	}
	
	public void makeTable(String line) {
		for(int x = 0; x < line.length(); x++) {
			System.out.print("-");
		}
		System.out.print("\n");

	}
	


}
	

