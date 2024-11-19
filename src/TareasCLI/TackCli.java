package TareasCLI;

import java.util.ArrayList;
import TareasCLI.gestor.taskFactory;
import TareasCLI.status.StatusTypo;


public class TackCli {

	public static void main(String[] args) {

		gestor gestor = new gestor();
		
		
		gestor.addTask("Dormir");
		gestor.addTask("Dormir");
		gestor.addTask("Dormir");
		gestor.addTask("Dormir");
		gestor.addTask("Dormir");
		
		switch(args[0]){
		case("add"):
			gestor.addTask(args[1]);
			break;
		case("update"):
			gestor.updateTask(args[1], args[2]);
			break;
		case("delete"):
			gestor.deleteTask(args[1]);
		break;
		/*
		case("mark-in-progress"):
			tasks.get(taskConvertor(args[1], tasks).id() - 1).updateStatus(StatusTypo.IN_PROGRESS);
		
		case("mark-done"):
			tasks.get(taskConvertor(args[1], tasks).id() - 1).updateStatus(StatusTypo.DONE);
		}
			*/

		}
		gestor.showTasks();
	}
}



