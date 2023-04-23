package model;

public class Capsule {

    private int id;

    private String capsuleDescription;


    private CapsuleType type;

    private String colabName;

    private String colabPosition ;

    private String lectionLearned;

    private boolean approveCapsule = false;

    private boolean isTheCapsulePublished = false;


    public Capsule(int id, String capsuleDescription, CapsuleType type, String colabName, String colabPosition,
     String lectionLearned) {

        this.id = id;
        this.capsuleDescription = capsuleDescription;
        this.type = type;
        this.colabName = colabName;
        this.colabPosition = colabPosition;
        this.lectionLearned = lectionLearned;
    }

    
    /** 
     * @param isTheCapsulePublished
     */
    // getters and setters

    
    public void setIsTheCapsulePublished( boolean isTheCapsulePublished){
        this.isTheCapsulePublished = isTheCapsulePublished;
    }
    
    /** 
     * @return boolean
     */
    public boolean getIsTheCapsulePublished(){
        return this.isTheCapsulePublished;
    }

    
    /** 
     * @param approveCapsule
     */
    public void setApproveCapsule( boolean approveCapsule){
        this.approveCapsule = approveCapsule;
    }
    
    /** 
     * @return boolean
     */
    public boolean getApprovecapsule(){
        return this.approveCapsule;
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getCapsulDescription() {
        return this.capsuleDescription;
    }

    
    /** 
     * @param capsulDescription
     */
    public void setCapsulDescription(String capsulDescription) {
        this.capsuleDescription = capsulDescription;
    }

    
    /** 
     * @return CapsuleType
     */
    public CapsuleType getType() {
        return this.type;
    }

    
    /** 
     * @param type
     */
    public void setType(CapsuleType type) {
        this.type = type;
    }

    
    /** 
     * @return String
     */
    public String getColabName() {
        return this.colabName;
    }

    
    /** 
     * @param colabName
     */
    public void setColabName(String colabName) {
        this.colabName = colabName;
    }

    
    /** 
     * @return String
     */
    public String getColabPosition() {
        return this.colabPosition;
    }

    
    /** 
     * @param colabPosition
     */
    public void setColabPosition(String colabPosition) {
        this.colabPosition = colabPosition;
    }

    
    /** 
     * @return String
     */
    public String getLectionLearned() {
        return this.lectionLearned;
    }

    
    /** 
     * @param lectionLearned
     */
    public void setLectionLearned(String lectionLearned) {
        this.lectionLearned = lectionLearned;
    }


        
}





