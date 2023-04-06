package model;

import java.util.Calendar;

public class Project {
    private static final int NUM_STAGES = 6;
    private Stage[] stages = new Stage[NUM_STAGES] ;
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

          

        this.stages[0] = new Stage("start", true, planedInitialDate0 , planedFinalDate0 );
        this.stages[1] = new Stage("analysis", false   , planedInitialDate1 , planedFinalDate1 );
        this.stages[2] = new Stage("design", false, planedInitialDate2 , planedFinalDate2);
        this.stages[3] = new Stage("execution", false  , planedInitialDate3 , planedFinalDate3);
        this.stages[4] = new Stage("closure ", false, planedInitialDate4 , planedFinalDate4);
        this.stages[5] = new Stage("project control", false , planedInitialDate5 , planedFinalDate5 );

    }

    
    // get


    public String getProjectName() {
        return this.projectName;
    }

    public String getClientName() {
        return this.clientName;
    }

    public Calendar getInitialDate() {
        return this.initialDate;
    }

    public Calendar getFinalDate() {
        return this.finalDate;
    }

    public double getBudget() {
        return this.budget;
    }

    public String getManagerNameG() {
        return this.managerNameG;
    }

    public String getManagerNumberG() {
        return this.managerNumberG;
    }

    public String getManagerNameC() {
        return this.managerNameC;
    }

    public String getManagerNumberC() {
        return this.managerNumberC;
    }

   
   /** 
    * 
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
     * @param id
     * @param capsuleDescription
     * @param type
     * @param colabName
     * @param colabPosition
     * @param lectionLearned
     * @return String
     */
    // case 2
   public String registerCapsule(int id,String capsuleDescription,String type ,
   String colabName, String colabPosition, String lectionLearned){
        int pos = activeStagePos();
        String msg="";

        if(pos != -1){
            msg= stages[pos].registerCapsule(id, capsuleDescription,type , colabName, 
            colabPosition, lectionLearned);
        }
        else if (pos == -1){
            msg="there aren not stages activated";
        }
        

        return msg;

    }
    
    /** 
     * @param searchStageByName
     * @param id
     * @return String
     */
    // case 3

    public String approveCapsule(String searchStageByName,int id){

        int pos= activeStagePos();
        String msg = "";

        if (pos!= -1 && stages[pos].getName().equalsIgnoreCase(searchStageByName)){

            msg=stages[pos].approveCapsule(id);
            

   
        }
        else{
            msg= "Capsule not found";
        }

        return msg; 

    
    }

        
        /** 
         * @param searchStageByName
         * @param id
         * @return String
        */
        
         // case 4
        public String publishCapsule(String searchStageByName,int id){

            int pos= activeStagePos();
            String msg = "";
    
            if (pos!= -1 && stages[pos].getName().equalsIgnoreCase(searchStageByName)){
    
                msg=stages[pos].publishCapsule(id);
                
    
       
            }
            else{
                msg= "Capsule not found";
            }
    
            return msg; 
    
    
        }

    
        
    
    /** 
     *
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



}
