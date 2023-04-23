package model;

import java.util.Calendar;

public class Project {
    private static final int NUM_STAGES = 6;
    private Stage[] stages = new Stage[NUM_STAGES] ;


    //    TECHNICAL, MANAGEMENT, DOMAIN , EXPERIENCES 
/*
    Un proyecto de un cliente se debe almacenar:
    1.	nombre del proyecto =)
    2.	nombre del cliente =)
    3.	fecha planeada para el inicio del proyecto  =)
    4.	fecha planeada para la finalización del proyecto =)
    5.	presupuesto =)
    6.	el nombre y número celular de el gerente del proyecto de green
    7.  el nombre y número celular de el gerente del proyecto del cliente

*/
    //attributes

    private String projectName;
    private String clientName;
    private Calendar initialDate;
    private Calendar finalDate;
    private double budget;
    private String managerNameG;
    private String managerNumberG;
    private String managerNameC;
    private String managerNumberC;

   



    public Project(String projectName,String clientName,Calendar initialDate,Calendar finalDate,double budget,
    String managerNameG,String managerNumberG, String managerNameC,String managerNumberC,
    Calendar planedInitialDate0 ,Calendar planedFinalDate0
    ,Calendar planedInitialDate1 ,Calendar planedFinalDate1
    ,Calendar planedInitialDate2 ,Calendar planedFinalDate2
    ,Calendar planedInitialDate3 ,Calendar planedFinalDate3
    ,Calendar planedInitialDate4 ,Calendar planedFinalDate4
    ,Calendar planedInitialDate5 ,Calendar planedFinalDate5){

        this.projectName = projectName;	
		this.clientName = clientName;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.budget = budget;
		this.managerNameG = managerNameG;
        this.managerNumberG = managerNumberG;
        this.managerNameC = managerNameC;
        this.managerNumberC = managerNumberC; 

        //StageType.START
        //StageType.ANALYSIS
        //StageType.DESIGN
        //StageType.EXECUTION
        //StageType.CLOSURE
        //StageType.PROJECT_CONTROL


        this.stages[0] = new Stage(StageType.START, true, planedInitialDate0 , planedFinalDate0 );
        this.stages[1] = new Stage(StageType.ANALYSIS, false   , planedInitialDate1 , planedFinalDate1 );
        this.stages[2] = new Stage(StageType.DESIGN, false, planedInitialDate2 , planedFinalDate2);
        this.stages[3] = new Stage(StageType.EXECUTION, false  , planedInitialDate3 , planedFinalDate3);
        this.stages[4] = new Stage(StageType.CLOSURE, false, planedInitialDate4 , planedFinalDate4);
        this.stages[5] = new Stage(StageType.PROJECT_CONTROL, false , planedInitialDate5 , planedFinalDate5 );

    }

    
    
    /** 
     * @return String
     */
    // get

    public String getProjectName() {
        return this.projectName;
    }

    
    /** 
     * @return String
     */
    public String getClientName() {
        return this.clientName;
    }

    
    /** 
     * @return Calendar
     */
    public Calendar getInitialDate() {
        return this.initialDate;
    }

    
    /** 
     * @return Calendar
     */
    public Calendar getFinalDate() {
        return this.finalDate;
    }

    
    /** 
     * @return double
     */
    public double getBudget() {
        return this.budget;
    }

    
    /** 
     * @return String
     */
    public String getManagerNameG() {
        return this.managerNameG;
    }

    
    /** 
     * @return String
     */
    public String getManagerNumberG() {
        return this.managerNumberG;
    }

    
    /** 
     * @return String
     */
    public String getManagerNameC() {
        return this.managerNameC;
    }

    
    /** 
     * @return String
     */
    public String getManagerNumberC() {
        return this.managerNumberC;
    }

   
   /** 
    * this method searchs the active stage position 
    * @return int
    */
   // localice active stage
    public int activeStagePos(){
        int pos = -1;
        boolean activeStagefounded = false;
        for(int i=0;i<NUM_STAGES && !activeStagefounded;i++){
            if(stages[i].getIsActive() && stages[i] != null ){
                activeStagefounded = true;
                pos=i;

            }
            
        }

        return pos;
   }
    
    /** 
     * this method allows to register a capsule
     * @param id
     * @param capsuleDescription
     * @param type
     * @param colabName
     * @param colabPosition
     * @param lectionLearned
     * @return String
    */

    // case 2
   public String registerCapsule(int id,String capsuleDescription,int type ,
   String colabName, String colabPosition, String lectionLearned){
        int pos = activeStagePos();
        String msg="";

        if(pos != -1){

            msg= stages[pos].registerCapsule(id, capsuleDescription, type , colabName, 
            colabPosition, lectionLearned);
        }
        else if (pos == -1){
            msg="there aren not stages activated";
        }
        

        return msg;

    }
    
    /** 
     * this method allows to approve a capsule
     * @param searchStageByName
     * @param id
     * @return String
     */

    // case 3
    
    public String approveCapsule(int searchStageByName,int id){

        int pos= activeStagePos();
        String msg = "";
        
//StageType.START
//StageType.ANALYSIS
//StageType.DESIGN
//StageType.EXECUTION
//StageType.CLOSURE
//StageType.PROJECT_CONTROL

        StageType searchStageByNameStageType; 
        if(searchStageByName == 1){
            searchStageByNameStageType = StageType.START; 
        }
        else if(searchStageByName == 2){
            searchStageByNameStageType = StageType.ANALYSIS; 
        }
        else if(searchStageByName == 3){
            searchStageByNameStageType = StageType.DESIGN; 
        }
        else if(searchStageByName == 4){
            searchStageByNameStageType = StageType.EXECUTION; 
        }
        else if(searchStageByName == 5){
            searchStageByNameStageType = StageType.CLOSURE; 
        }
        else{
            searchStageByNameStageType = StageType.PROJECT_CONTROL;
        }

        if (pos!= -1 && stages[pos].getName() == searchStageByNameStageType){

            msg=stages[pos].approveCapsule(id);
            

   
        }
        else{
            msg= "Capsule not found";
        }

        return msg; 

    
    }

        
        /** 
         * this method allows to publish a capsule
         * @param searchStageByName
         * @param id
         * @return String
        */
        
        // case 4
        public String publishCapsule(int searchStageByName,int id){

            int pos= activeStagePos();
            String msg = "";
            StageType searchStageByNameStageType; 
            if(searchStageByName == 1){
                searchStageByNameStageType = StageType.START; 
            }
            else if(searchStageByName == 2){
                searchStageByNameStageType = StageType.ANALYSIS; 
            }
            else if(searchStageByName == 3){
                searchStageByNameStageType = StageType.DESIGN; 
            }
            else if(searchStageByName == 4){
                searchStageByNameStageType = StageType.EXECUTION; 
            }
            else if(searchStageByName == 5){
                searchStageByNameStageType = StageType.CLOSURE; 
            }
            else{
                searchStageByNameStageType = StageType.PROJECT_CONTROL;
            }

    
            if (pos!= -1 && stages[pos].getName()==searchStageByNameStageType){
    
                msg=stages[pos].publishCapsule(id);
                
    
       
            }
            else{
                msg= "Capsule not found";
            }
    
            return msg; 
    
    
        }

    
        
    
    /** 
     * this method allows to chage a stage
     *  @return String
     * 
    */
    // Case 5
    public String changeStage(){
        String msg ="x";
        int pos = activeStagePos();
        int newPos = pos+1;
        Calendar date = Calendar.getInstance();
        if (pos>=0 && pos<6 ){

            stages[pos].setRealFinalDate(date);
            stages[pos].setIsActive(false);

            stages[newPos].setRealInitialDate(date);
            stages[newPos].setIsActive(true);
            msg = "The new active stage is " + stages[newPos].getName();

        }
        else if(pos == 6){
            stages[pos].setRealFinalDate(date);
            stages[pos].setIsActive(false);
            msg ="The project is over all the stages of the project have been completed";

        }
        else if (pos == -1){
            msg="dgh";
        }
        return msg;
        
    }
    
    /** 
     * This method shows the number of capsules for every type of a project and stage in specific
     * @param searchStageByName
     * @return String
     */
    //case 6
    public String showNumOfEveryCapsuleType(int searchStageByName){
        String msg = "no2";
            //    TECHNICAL, MANAGEMENT, DOMAIN , EXPERIENCES 
        if(searchStageByName == 1 && stages[0]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[0].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[0].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[0].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[0].getNumOfExperiencesCapsules()) + "\n";
                 
        }
        else if(searchStageByName == 2 && stages[1]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[1].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[1].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[1].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[1].getNumOfExperiencesCapsules()) + "\n";
        }
        else if(searchStageByName == 3 && stages[2]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[2].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[2].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[2].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[2].getNumOfExperiencesCapsules()) + "\n";
        }
        else if(searchStageByName == 4 && stages[3]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[3].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[3].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[3].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[3].getNumOfExperiencesCapsules()) + "\n";
        }
        else if(searchStageByName == 5 && stages[4]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[4].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[4].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[4].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[4].getNumOfExperiencesCapsules()) + "\n";
        }
        else if(searchStageByName == 6 && stages[5]!=null){
                msg= "TECHNICAL Capsules: "+ Integer.toString(stages[5].getNumOfTechicalCapsules()) + "\n" 
                + "MANAGEMENT Capsules: "+ Integer.toString(stages[5].getNumOfManagementCapsules()) + "\n"
                +"DOMAIN Capsules: " +Integer.toString(stages[5].getNumOfDomainCapsules()) + "\n"
                +"EXPERIENCES Capsules: "+ Integer.toString(stages[5].getNumOfExperiencesCapsules()) + "\n";
        }


        return msg;

    }
        
    
    /** 
     * returns the total of capsules
     * @return int
     */
    public int getTotalCapsules(){
        int totalCapsules =0;
        for(int i =0;i<NUM_STAGES;i++){
            totalCapsules+=stages[i].getNumOfDomainCapsules()+stages[i].getNumOfExperiencesCapsules()
            +stages[i].getNumOfManagementCapsules()+stages[i].getNumOfTechicalCapsules();

        }
            
        return totalCapsules;

    }

    
    /** 
     * This method lists the learned lessons for a project in a specific stage
     * @param searchStageByName
     * @return String
     */
    //case 7
    public String listLessonsLearnedOfProjectForAStage(int searchStageByName){
        String msg ="";
        int stagePos= searchStageByName -1;
        msg=stages[stagePos].listLessonsLearnedOfProjectForAStage();

        return msg;
    }

    
    /** 
     * This method allows to know if a collaborator has register at least one capsule
     * @param searchCollaboratorNameInCapsules
     * @return boolean
     */
    //case 9
    public boolean checkCollaboratorsCapsulesInProjects(String searchCollaboratorNameInCapsules){
        boolean collaboratorFound =false;
        for(int i=0;i<NUM_STAGES && !collaboratorFound;i++){
            if(stages[i].checkCollaboratorsCapsulesInProjects(searchCollaboratorNameInCapsules)){

                collaboratorFound= true;
            }
            
        }
        return collaboratorFound;
    
    }

    
    /** 
     * This method shows the lesson , the description , the project and the stage if a key word is found
     * @param keyword
     * @return String
     */
    //case 10
    public String searchLessonByKeyWords(String keyword){
        String msg="";
        for(int i =0;i<NUM_STAGES;i++){
            if(stages[i].searchLessonByKeyWords(keyword)!=""){
                msg+="\n Stage: "+stages[i].getName()+stages[i].searchLessonByKeyWords(keyword);
            }
            

        }
        return msg;

    }

   
}





