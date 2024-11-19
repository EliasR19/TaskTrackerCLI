package TareasCLI;

import java.util.ArrayList;
import TareasCLI.gestor.taskFactory;
import TareasCLI.status.StatusTypo;


public class TackCli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<tareas> tasks = new ArrayList<tareas>();
		
		tareas tarea1 = taskFactory.crear("Dormir");
		tasks.add(tarea1);
		
		switch(args[0]){
		case("add"):
			tasks.add(taskFactory.crear(args[1]));	
			
		case("update"):
			tasks.get(taskConvertor(args[1], tasks).id() - 1).update(args[2]);
			
		case("delete"):
			tasks.remove(Integer.valueOf(args[1])-1);
		
		case("mark-in-progress"):
			tasks.get(taskConvertor(args[1], tasks).id() - 1).updateStatus(StatusTypo.IN_PROGRESS);
		
		case("mark-done"):
			tasks.get(taskConvertor(args[1], tasks).id() - 1).updateStatus(StatusTypo.DONE);
		}
			
		if(args[0].equals("add")) {
			System.out.println(args[0] + " "+ tasks.getLast().id()+ " -" + tasks.getLast().description() + "- status: " + tasks.getLast().status());
			
		}else {
			System.out.println(args[0] + " "+ taskConvertor(args[1], tasks).id() + " " + taskConvertor(args[1], tasks).description() + " status: " + taskConvertor(args[1], tasks).status());
		}
		
		
	}
	
	public static tareas taskConvertor(String n, ArrayList<tareas> t) {
		return t.get(Integer.valueOf(n)-1);
		//pasa el String a Int
	}

}
