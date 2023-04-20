package model;

import java.util.Calendar;


public class Stage{
    public static final int NUM_CAPSULS = 50;
    private Capsule[] capsules;
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

    }

 


    // getters and setters

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
        
        if (pos != -1){
            
            //    TECHNICAL, MANAGEMENT, DOMAIN , EXPERIENCES 

			CapsuleType capsuleType; 
			if(type == 1){
				capsuleType = CapsuleType.TECHNICAL; 
			}
			else if(type == 2){
				capsuleType = CapsuleType.MANAGEMENT; 
			}
			else if(type == 3){
				capsuleType = CapsuleType.DOMAIN; 
			}
			else{
				capsuleType = CapsuleType.EXPERIENCES;
			}

            capsules[pos]= new Capsule(id, capsuleDescription,capsuleType , colabName, 
            colabPosition, lectionLearned);

            msg = "Capsule registered successfully";

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



}