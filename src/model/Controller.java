package model;

import java.util.Calendar;

public class Controller {
	public static final int SIZE = 10;
	private Project[] projects;
    private String[] keywords;
    public static final int NUM_KEYWORDS = 100;

	public Controller() {

		projects = new Project[SIZE];
        keywords = new String[NUM_KEYWORDS];
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
     * this method allows to register a capsule
     * @param searchProjectByName
     * @param id
     * @param capsuleDescription
     * @param type
     * @param colabName
     * @param colabPosition
     * @param lectionLearned
     * @return String
    */
    // Case 2

    public String registerCapsule(String searchProjectByName, int id,String capsuleDescription,int type ,
    String colabName, String colabPosition, String lectionLearned){

        int pos =searchProjectPosition(searchProjectByName);
        String msg = "no";
        if (pos!= -1){

            msg = projects[pos].registerCapsule(id, capsuleDescription,type , colabName, 
            colabPosition, lectionLearned );
            addKeyWords(lectionLearned);
            eliminateDuplicate();
            addKeyWords(capsuleDescription);
            eliminateDuplicate();
        }
        else{
            msg = "project has not been Found";
        }



        return msg; 
   

        
    }
    
    /** 
     * this method searches for the position of a specific project  
     * @param searchProjectByName
     * @return int
     */
    // search project position

    public int searchProjectPosition(String searchProjectByName){
        int pos=-1;
        boolean projectFound = false;
        for(int i=0; i<SIZE && !projectFound;i++){
            //while(projects[i] != null){
                if(projects[i]!= null&&projects[i].getProjectName().equalsIgnoreCase(searchProjectByName) ){
                    projectFound = true;
                    pos=i;
    
    
                }

            //}


        }
        return pos;

    }

    
    /** 
     * this method allows to approve a capusule
     * @param searchProjectByName
     * @param searchStageByName
     * @param id
     * @return String
     */

    // Case 3
    public String approveCapsule(String searchProjectByName, int searchStageByName,int id){

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
     * this method allows to publish a capsule
     * @param searchProjectByName
     * @param searchStageByName
     * @param id
     * @return String
    */
    // Case 4

    public String publishCapsule(String searchProjectByName, int searchStageByName,int id){
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
     * this method allows to change the stage of a specific project
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

    
    /** 
     * This method shows the number of capsules for every type of a project and stage in specific
     * @param searchProjectByName
     * @param searchStageByName
     * @return String
     */
    //case 6
    public String showNumOfEveryCapsuleType(String searchProjectByName, int searchStageByName){
        String msg = "no";
        int pos = searchProjectPosition(searchProjectByName);

        if (pos != -1){
            msg=projects[pos].showNumOfEveryCapsuleType(searchStageByName);

        }
        else{

            msg="project has not been Found";
        }

        return msg;

    }
    
    
    /** 
     * This method lists the learned lessons for a project in a specific stage
     * @param searchProjectByName
     * @param searchStageByName
     * @return String
     */
    //case 7
    public String listLessonsLearnedOfProjectForAStage(String searchProjectByName,int searchStageByName){
        String msg ="";
        int pos = searchProjectPosition(searchProjectByName);

        if(pos!=-1){
            msg= projects[pos].listLessonsLearnedOfProjectForAStage(searchStageByName);

        }
        else{
            msg="project has not been Found";
        }
        return msg;
    }


    
    /** 
     * This method allows know which project has more capsules
     * @return String
     */
    //case 8
    public String getNameOfTheProjectWithMoreCapsules(){
        int pos = getPosOfTheProjectWithMoreCapsules();
        String msg ="The project with the most amout of capsules is: "+ projects[pos].getProjectName();
        
        return msg;

    }

    
    /** 
     * this method retunrs the position of the project with more capsules
     * @return int
     */
    public int getPosOfTheProjectWithMoreCapsules(){
        int projectWithMoreCapsulesPos = 0;
        int maxCapsules = 0;

        for(int i=0;i<SIZE;i++){
            if(projects[i]!=null){
                if(i==0){
                    maxCapsules=projects[0].getTotalCapsules();
                    projectWithMoreCapsulesPos = 0;
                }
                else{
                    if(projects[i].getTotalCapsules()>maxCapsules && projects[i]!=null){
                        projectWithMoreCapsulesPos = i;
    
    
                    }
    
                }

            }
            

 
        }
        return projectWithMoreCapsulesPos;

    }

    
    /** 
     *This method allows to know if a collaborator has register at least one capsule

     * @param searchCollaboratorNameInCapsules
     * @return String
     */
    //case 9
    public String checkCollaboratorsCapsulesInProjects(String searchCollaboratorNameInCapsules){
        String msg ="The collaborator has not registered any capsule";
        boolean collaboratorFound =false;
        for(int i=0;i<SIZE && !collaboratorFound;i++){
            if(projects[i]!=null && projects[i].checkCollaboratorsCapsulesInProjects(searchCollaboratorNameInCapsules)){

                msg="The collaborator has registed at least 1 capsule in the project: "+projects[i].getProjectName();
                collaboratorFound = true;
            }
        
        }
        return msg;
    }

    
    /** 
     * extracts the keywords of the lection Learned
     * @param lectionLearned
     */
    //case 10

    //add key words

    public void addKeyWords(String lectionLearned){
        int startIndex = lectionLearned.indexOf("#");
        int endIndex = lectionLearned.indexOf("#", startIndex + 1);

        while (startIndex != -1 && endIndex != -1 && endIndex > startIndex + 1) {
            String keyword = lectionLearned.substring(startIndex + 1, endIndex);
            // Add the keyword to the array
            int pos = getAvailablePosKeyWords();
            if(pos != -1){
                keywords[pos] = keyword;     
                // Update startIndex and endIndex for next iteration
                startIndex = lectionLearned.indexOf("#", endIndex + 1);
                endIndex = lectionLearned.indexOf("#", startIndex + 1);
        } 
        else {
            break;
        }
    }
}

    
    // eliminate duplicate
    /**
     * this method eliminates the duplicate keywords
     */
    public void eliminateDuplicate(){
        for(int i = 0; i < NUM_KEYWORDS; i++){
            for(int j = i + 1; j < NUM_KEYWORDS; j++){ 
                if(keywords[i] != null && keywords[j] != null){
                    if(keywords[i].equalsIgnoreCase(keywords[j])){
                        keywords[j] = null; 
                    }
                }
            }
        }
    }

    
    /** 
     * returns the available position in the keywords array
     * @return int
     */
    public int getAvailablePosKeyWords(){
        int pos = -1;
        boolean posFound = false;
        for(int i =0;i<NUM_KEYWORDS && !posFound ;i++){
            posFound = true;
            pos = 1;
        }
        return pos;
    }
    
    /** 
     * This method retuns the lesson , the description , the project and the stage if a key word is found
     * @param keyword
     * @return String
     */
    public String searchLessonByKeyWords(String keyword){
        String msg="";

        for(int i=0;i<SIZE ;i++){
            if(projects[i]!=null){
                if(projects[i].searchLessonByKeyWords(keyword)!= ""){
                    msg+="\n Project: " +projects[i].getProjectName()+projects[i].searchLessonByKeyWords(keyword);
                }
                
                
            }
        
        }
        

        return msg;


    }
}
