package model;

public class Capsul {
    /*
    Una cápsula tiene:

    1.	un identificador único
    2.	una descripción de la situación que desea registrar
    3.	un tipo de cápsula (los tipos definidos hasta el momento son técnico,
        gestión, dominio y experiencias), 
    4.	el nombre colaborador
    5. cargo del colaborador 
    6.	el aprendizaje o lección aprendida con dicha situación

    */
    
    private int id;
    private String capsulDescription;

    private String type;

    private String colabName;

    private String colabPosition ;

    private String lectionLearned;


    public Capsul(int id, String capsulDescription, String type, String colabName, String colabPosition,
     String lectionLearned) {

        this.id = id;
        this.capsulDescription = capsulDescription;
        this.type = type;
        this.colabName = colabName;
        this.colabPosition = colabPosition;
        this.lectionLearned = lectionLearned;
    }

    // getters and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapsulDescription() {
        return this.capsulDescription;
    }

    public void setCapsulDescription(String capsulDescription) {
        this.capsulDescription = capsulDescription;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
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





