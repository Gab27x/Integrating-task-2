package model;

import java.util.Calendar;


public class Stage{
    public static final int NUM_CAPSULS = 50;
    private Capsule[] capsules;
    private int numOfTechicalCapsules = 0;
    private int numOfManagementCapsules = 0;
    private int numOfDomainCapsules = 0;
    private int numOfExperiencesCapsules = 0;
    private int[] allIds;

    /*
    Cuando se crea el proyecto, automáticamente se crean sus 6 etapas:
    1.	inicio
    2.	análisis
    3.	diseño
    4.	ejecución
    5.	cierre 
    6.	control del proyecto

    Cada etapa tendrá una fecha de inicio y fin (planeada) y una fecha de inicio y fin (real).
    solo la etapa de inicio queda activa. 

    */
    //StageType
    private StageType name;
    private Calendar planedInitialDate;
    private Calendar planedFinalDate;
    private Calendar realInitialDate;
    private Calendar realFinalDate;
    private boolean isActive;
    
    

    public Stage(StageType name, boolean isActive,Calendar planedInitialDate,Calendar planedFinalDate ){
        this.name = name;
        this.isActive = isActive;
        capsules = new Capsule[NUM_CAPSULS];
        allIds = new int[NUM_CAPSULS];
    }

 


    // getters and setters
    public int getNumOfTechicalCapsules() {
        return this.numOfTechicalCapsules;
    }

    public void setNumOfTechicalCapsules(int numOfTechicalCapsules) {
        this.numOfTechicalCapsules = numOfTechicalCapsules;
    }

    public int getNumOfManagementCapsules() {
        return this.numOfManagementCapsules;
    }

    public void setNumOfManagementCapsules(int numOfManagementCapsules) {
        this.numOfManagementCapsules = numOfManagementCapsules;
    }

    public int getNumOfDomainCapsules() {
        return this.numOfDomainCapsules;
    }

    public void setNumOfDomainCapsules(int numOfDomainCapsules) {
        this.numOfDomainCapsules = numOfDomainCapsules;
    }

    public int getNumOfExperiencesCapsules() {
        return this.numOfExperiencesCapsules;
    }

    public void setNumOfExperiencesCapsules(int numOfExperiencesCapsules) {
        this.numOfExperiencesCapsules = numOfExperiencesCapsules;
    }

    public StageType getName() {
        return this.name;
    }

    public void setName(StageType name) {
        this.name = name;
    }

    public Calendar getPlanedInitialDate() {
        return this.planedInitialDate;
    }

    public void setPlanedInitialDate(Calendar planedInitialDate) {
        this.planedInitialDate = planedInitialDate;
    }

    public Calendar getPlanedFinalDate() {
        return this.planedFinalDate;
    }

    public void setPlanedFinalDate(Calendar planedFinalDate) {
        this.planedFinalDate = planedFinalDate;
    }

    public Calendar getRealInitialDate() {
        return this.realInitialDate;
    }

    public void setRealInitialDate(Calendar realInitialDate) {
        this.realInitialDate = realInitialDate;
    }

    public Calendar getRealFinalDate() {
        return this.realFinalDate;
    }

    public void setRealFinalDate(Calendar realFinalDate) {
        this.realFinalDate = realFinalDate;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    
    /** 
     * this method searchs an available place in the capsule array
     * @return int
     */

    // search for empty capsule 
    public int capsuleAvailable(){
		int pos = -1;
		boolean posFounded = false;

		for (int i=0;i <NUM_CAPSULS && !posFounded; i++){
			if (capsules[i] == null){

				pos = i;
				posFounded = true;
			}

		}

		return pos;
	}
    public boolean isIdAvailable(int id){
        boolean idIsAvailable = true ;
        for(int i=0;i<NUM_CAPSULS&& idIsAvailable;i++){
            if(capsules[i]!=null && capsules[i].getId()== id){
                idIsAvailable = false;

            }
        }
        return idIsAvailable;
    }
    
    /** 
     * this method allows to create a new capsule using the class constructure
     * @param id
     * @param capsuleDescription
     * @param type
     * @param colabName
     * @param colabPosition
     * @param lectionLearned
     * @return String
     */
    //case 2
    public String registerCapsule(int id,String capsuleDescription,int type ,
    String colabName, String colabPosition, String lectionLearned){
        int pos = capsuleAvailable();

        String msg="";

        if (pos != -1 && isIdAvailable(id)){
            
            //    TECHNICAL, MANAGEMENT, DOMAIN , EXPERIENCES 

			CapsuleType capsuleType; 
			if(type == 1){
				capsuleType = CapsuleType.TECHNICAL; 
                numOfTechicalCapsules +=1;

			}
			else if(type == 2){
				capsuleType = CapsuleType.MANAGEMENT; 
                numOfManagementCapsules +=1;
			}

			else if(type == 3){
				capsuleType = CapsuleType.DOMAIN; 
                numOfDomainCapsules +=1;
			}
			else{
				capsuleType = CapsuleType.EXPERIENCES;
                numOfExperiencesCapsules +=1;
			}

            capsules[pos]= new Capsule(id, capsuleDescription,capsuleType , colabName, 
            colabPosition, lectionLearned);

            msg = "Capsule registered successfully";
            allIds[pos] = id ;
        }
        else if(!isIdAvailable(id)){
            msg="The id is not available";


        }
        else{

            msg="the are not capsules available";
        }
        
        return msg;

    }


    
    /** 
     * this method search the position of a capsule using the id
     * @param id
     * @return int
    */
    public int searchPosById(int id){
        int pos = -1;
        boolean capsuleFound = false;

		for (int i=0;i <NUM_CAPSULS && !capsuleFound; i++){
			if (capsules[i] != null && capsules[i].getId() == id ){
				pos = i;
			}

		}

        return pos;

    }


    
    /** 
     * this method allows to approve a specific capsule 
     * @param id
     * @return String
     */
    // case 3
    public String approveCapsule(int id){

        boolean idFounded= false;
        String msg = "";


        for(int i =0; i<NUM_CAPSULS && !idFounded ;i++){
            if (capsules[i]!= null && capsules[i].getId() == id ){
                Boolean approved = true;
                capsules[i].setApproveCapsule(approved);
                msg = "capsule approved";
                idFounded = true;
            }
            else{

                msg="Id does not match";
            }


        }
            
        return msg;
   
        }

        
        /** 
         * this method allows to publish a specific capsule 
         * @param id
         * @return String
         */
        // case 4
    public String publishCapsule(int id){
        String msg = "";
        int pos = searchPosById(id);


        if(pos != -1){
            capsules[pos].setIsTheCapsulePublished(true);
            msg = "capsule published" ;

        }
        else{
            msg="The capsule is not approved";

        }
        return msg; 
    
    
    }

    //case 7
    public String listLessonsLearnedOfProjectForAStage( ){
        String msg ="no";

        for(int i=0;i<NUM_CAPSULS;i++){
          if(capsules[i] != null){
            msg+="\n\t Capsule "+(i+1)+ "\n"+ "Lection learned: "+capsules[i].getLectionLearned();
          }
            
        }               

           
        return msg;
    }


    //case 9
    public boolean checkCollaboratorsCapsulesInProjects(String searchCollaboratorNameInCapsules){
        boolean collaboratorFound =false;
        for(int i=0;i<NUM_CAPSULS && !collaboratorFound;i++){
            if(capsules[i]!=null&& capsules[i].getColabName().equalsIgnoreCase(searchCollaboratorNameInCapsules)){
                collaboratorFound = true;
            }

            
        }
    
        return collaboratorFound;
    }
        //case 10
        public String searchLessonByKeyWords(String keyword){
            String msg="";
            for(int i =0;i<NUM_CAPSULS;i++){
                if(capsules[i]!=null&& capsules[i].getApprovecapsule()&&capsules[i].getIsTheCapsulePublished()){
                    String lectionLearned = capsules[i].getLectionLearned();
                    if(isTheKeyWordInTheLesson(lectionLearned,keyword)){
                        msg+= "\n LectionLearned: "+capsules[i].getLectionLearned();

                    }
                    
                }
    
            }
            return msg;
    
    }
    public boolean isTheKeyWordInTheLesson(String lectionLearned,String keyword){
        boolean keyWordFound = false;
        String[] keyWordsExtracted = new String[20];
        int numKeywords =0;
        int startIndex = lectionLearned.indexOf("#");
        int endIndex = lectionLearned.indexOf("#", startIndex + 1);
        while (startIndex != -1 && endIndex != -1 && endIndex > startIndex + 1) {
        String newKeyword = lectionLearned.substring(startIndex + 1, endIndex);
        // Add the keyword to the array
        keyWordsExtracted[numKeywords++] = newKeyword;     
        // Update startIndex and endIndex for next iteration
        startIndex = lectionLearned.indexOf("#", endIndex + 1);
        endIndex = lectionLearned.indexOf("#", startIndex + 1);
        
        }
        for(int i=0;i<20 && !keyWordFound;i++){
            if(keyWordsExtracted[i]!=null && keyWordsExtracted[i].equalsIgnoreCase(keyword)){
                keyWordFound= true;

            }

        }
        return keyWordFound;
    

    }
}
    



