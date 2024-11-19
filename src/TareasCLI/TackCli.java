package TareasCLI;

import java.util.ArrayList;
import TareasCLI.status.StatusTypo;


public class TackCli {

	public static void main(String[] args) {

		gestor gestor = new gestor();
		
		gestor.loadTask();
		
//		gestor.addTask("Dormir");
//		gestor.addTask("Dormir");
//		gestor.addTask("Dormir");
//		gestor.addTask("Dormir");
//		gestor.addTask("Dormir");
		
		switch(args[0]){
		case("add"):
			System.out.println("Agregando...");
			gestor.addTask(args[1]);
			break;
		case("update"):
			gestor.updateTask(args[1], args[2]);
			break;
		case("remove"):
			gestor.removeTask(args[1]);
			break;
		case("remove-all"):
			gestor.removeAll();
			break;
		case("mark-in-progress"):
			gestor.updateStatus(StatusTypo.IN_PROGRESS, args[1]);
			break;
		
		case("mark-done"):
			gestor.updateStatus(StatusTypo.DONE, args[1]);
			break;
		case("list"):
			if(args.length == 1) {
				gestor.showTasks("all");
			} else {
				gestor.showTasks(args[1]);
				break;
			}
		}
		

		
		
		gestor.saveTasks();
		//gestor.showTasks();
		//Prueba de commit
	}
	
}



