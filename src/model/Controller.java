package model;

import java.util.Calendar;

public class Controller {
	public static final int SIZE = 10;
	private Project[] projects;

	public Controller() {

		projects = new Project[SIZE];
	
	}

    
    // Case 1
    /** 
     * this method creates a project using the class constructor and returns a confirmation message
     * 
     * @param projectName
     * @param clientName
     * @param initialDate
     * @param finalDate
     * @param budget
     * @param managerNameG
     * @param managerNumberG
     * @param managerNameC
     * @param managerNumberC
     * @param planedInitialDate0
     * @param planedFinalDate0
     * @param planedInitialDate1
     * @param planedFinalDate1
     * @param planedInitialDate2
     * @param planedFinalDate2
     * @param planedInitialDate3
     * @param planedFinalDate3
     * @param planedInitialDate4
     * @param planedFinalDate4
     * @param planedInitialDate5
     * @param planedFinalDate5
     * @return String
    */

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




    /** 
     * this method search's an available position on the projects array
     * @return int
    */

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



    
    /** 
     * 
     * @param searchProjectPosition
     * @param id
     * @param capsuleDescription
     * @param type
     * @param colabName
     * @param colabPosition
     * @param lectionLearned
     * @return String
    */
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
    
    /** 
     * 
     * @param searchProjectByName
     * @return int
     */
    // search project position

    public int searchProjectPosition(String searchProjectByName){
        int pos=-1;
        boolean projectFound = false;
        for(int i=0; i<SIZE && !projectFound;i++){
            while(projects[i] != null){
                if(projects[i].getProjectName().equalsIgnoreCase(searchProjectByName) && projects[i]!= null ){
                    projectFound = true;
                    pos=i;
    
    
                }

            }


        }
        return pos;

    }

    
    /** 
     * 
     * @param searchProjectByName
     * @param searchStageByName
     * @param id
     * @return String
     */
    // Case 3
    public String approveCapsule(String searchProjectByName, String searchStageByName,int id){

        int pos =searchProjectPosition(searchProjectByName);
        String msg = "";

        if (pos!= -1){
            msg= projects[pos].approveCapsule( searchStageByName, id);
        }
        else if (pos == -1){
            msg = "project has not been Found";
        }

        return msg; 

    }

    
    /** 
     * 
     * @param searchProjectByName
     * @param searchStageByName
     * @param id
     * @return String
     */
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

    
    /** 
     * 
     * @param searchProjectByName
     * @return String
    */

    // Case 5
    public String changeStage(String searchProjectByName){
        int pos = searchProjectPosition(searchProjectByName);
        String msg="o";

        if (pos!= -1){
            msg= projects[pos].changeStage();
        }
        else{
            msg = "project has not been Found";
        }

        return msg ;
          
    }


    
}
