package TareasCLI;

import TareasCLI.status.StatusTypo;

public class gestor {
	
	public static class taskFactory {
		
		public static tareas crear(String d) {
			return new tareas(d, StatusTypo.TODO);
		}
	}
	
}
