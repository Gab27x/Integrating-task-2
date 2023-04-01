package model;

public class Stage{
    public static final int NUM_CAPSULS = 50;
    /*
    Cuando se crea el proyecto, automáticamente se crean sus 6 etapas:
    1.	inicio
    2.	análisis
    3.	diseño
    4.	ejecución
    5.	cierre 
    6.	seguimiento 
    7.	control del proyecto

    Cada etapa tendrá una fecha de inicio y fin (planeada) y una fecha de inicio y fin (real).
    solo la etapa de inicio queda activa. 

    Para lograr asignar las fechas planeadas se deberá solicitar al usuario la cantidad de meses que se lleva cada etapa (arreglo de cantidad de meses).

    */
    private boolean start = true;
    private boolean analysis = false;
    private boolean design = false;
    private boolean execution= false;
    private boolean closure = false;
    private boolean followUp = false;
    private boolean projectControl= false;

    public Stage(){

        Capsul[] capsuls = new Capsul[NUM_CAPSULS];

    }

   


    public boolean getStart() {
        return this.start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }



    public boolean getAnalysis() {
        return this.analysis;
    }

    public void setAnalysis(boolean analysis) {
        this.analysis = analysis;
    }


    public boolean getDesign() {
        return this.design;
    }

    public void setDesign(boolean design) {
        this.design = design;
    }


    public boolean getExecution() {
        return this.execution;
    }

    public void setExecution(boolean execution) {
        this.execution = execution;
    }


    public boolean getClosure() {
        return this.closure;
    }

    public void setClosure(boolean closure) {
        this.closure = closure;
    }


    public boolean getFollowUp() {
        return this.followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }


    public boolean getProjectControl() {
        return this.projectControl;
    }

    public void setProjectControl(boolean projectControl) {
        this.projectControl = projectControl;
    }




}