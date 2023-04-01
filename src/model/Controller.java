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
    String managerNameG,String managerNumberG, String managerNameC,String managerNumberC,
    Calendar planedInitialDate0 ,Calendar planedFinalDate0
    ,Calendar planedInitialDate1 ,Calendar planedFinalDate1
    ,Calendar planedInitialDate2 ,Calendar planedFinalDate2
    ,Calendar planedInitialDate3 ,Calendar planedFinalDate3
    ,Calendar planedInitialDate4 ,Calendar planedFinalDate4
    ,Calendar planedInitialDate5 ,Calendar planedFinalDate5){
        String msg = "Couldn't create the project";
        int pos = posAvailable();
        if(pos != -1){
            
			projects[pos] = new Project(projectName, clientName, initialDate, finalDate, budget,
            managerNameG, managerNumberG,  managerNameC, managerNumberC,
            planedInitialDate0 , planedFinalDate0
            , planedInitialDate1 , planedFinalDate1
            , planedInitialDate2 , planedFinalDate2
            , planedInitialDate3 , planedFinalDate3
            , planedInitialDate4 , planedFinalDate4
            , planedInitialDate5 , planedFinalDate5);

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
    public String registerCapsule(String searchProjectPosition, int id,String capsuleDescription,String type ,
    String colabName, String colabPosition, String lectionLearned){

        int pos =searchProjectPosition(searchProjectPosition);
        String msg = "";
        if (pos!= -1){

            msg = projects[pos].registerCapsule(id, capsuleDescription,type , colabName, 
            colabPosition, lectionLearned );
        }
        else{
            msg = "project has not been Found";
        }



        return msg; 
   

        
    }
    // search project position

    public int searchProjectPosition(String searchProjectByName){
        int pos=-1;
        boolean projectFound = false;
        for(int i=0; i<SIZE && !projectFound;i++){
            if(projects[i].getProjectName().equalsIgnoreCase(searchProjectByName) && projects[i]!= null ){
                projectFound = true;
                pos=i;


            }

        }
        return pos;

    }

    // Case 3
    public String approveCapsule(String searchProjectByName, String searchStageByName,int id){

        int pos =searchProjectPosition(searchProjectByName);
        String msg = "";

        if (pos!= -1){
            msg= projects[pos].approveCapsule( searchStageByName, id);
        }
        else{
            msg = "project has not been Found";
        }

        return msg; 

    }

    // Case 4

    public String publishCapsule(String searchProjectByName, String searchStageByName,int id){
        int pos =searchProjectPosition(searchProjectByName);
        String msg = "";

        if (pos!= -1){
            msg= projects[pos].publishCapsule( searchStageByName, id);
        }
        else{
            msg = "project has not been Found";
        }

        return msg;
        
    }

    // Case 5
    public String changeStage(String searchProjectByName){
        int pos = searchProjectPosition(searchProjectByName);
        String msg="";
        if (pos!= -1){
            msg= projects[pos].changeStage();
        }
        else{
            msg = "project has not been Found";
        }

        return msg ;
          
    }


    
}
