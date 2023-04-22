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

    // getters and setters

    
    public void setIsTheCapsulePublished( boolean isTheCapsulePublished){
        this.isTheCapsulePublished = isTheCapsulePublished;
    }
    public boolean getIsTheCapsulePublished(){
        return this.isTheCapsulePublished;
    }

    public void setApproveCapsule( boolean approveCapsule){
        this.approveCapsule = approveCapsule;
    }
    public boolean getApprovecapsule(){
        return this.approveCapsule;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapsulDescription() {
        return this.capsuleDescription;
    }

    public void setCapsulDescription(String capsulDescription) {
        this.capsuleDescription = capsulDescription;
    }

    public CapsuleType getType() {
        return this.type;
    }

    public void setType(CapsuleType type) {
        this.type = type;
    }

    public String getColabName() {
        return this.colabName;
    }

    public void setColabName(String colabName) {
        this.colabName = colabName;
    }

    public String getColabPosition() {
        return this.colabPosition;
    }

    public void setColabPosition(String colabPosition) {
        this.colabPosition = colabPosition;
    }

    public String getLectionLearned() {
        return this.lectionLearned;
    }

    public void setLectionLearned(String lectionLearned) {
        this.lectionLearned = lectionLearned;
    }


        
}





