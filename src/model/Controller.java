package model;

import java.util.Calendar;

public class Controller {
	public static final int SIZE = 10;
	private Project[] projects;

	public Controller() {

		projects = new Project[SIZE];
	
	}

    // Case 1
    public String createProject(String projectName,String clientName,Calendar initialDate,Calendar finalDate,double budget,
    String managerNameG,String managerNumberG, String managerNameC,String managerNumberC ){
        String msg = "Couldn't create the project";
        int pos = posAvailable();
        if(pos != -1){
            
			projects[pos] = new Project(projectName,clientName,initialDate,finalDate,
            budget,managerNameG,managerNumberG,managerNameC,managerNumberC) ;
			msg = "Project created";
		}

        return msg;
    }



	public int posAvailable(){
		int pos = -1;
		boolean posFounded = false;

		for (int i=0;i <SIZE && !posFounded; i++){
			if (projects[i] == null){

				pos = i;
				posFounded = true;
			}

		}


		
		return pos;
	}



    // Case 2
    public void registerCapsule(){


        
    }

    // Case 3
    public void approvecapsule(){


        
    }

    // Case 4

    public void publishCapsule(){


        
    }

    // Case 5
    public void changeStage(){


        
    }


    
}
