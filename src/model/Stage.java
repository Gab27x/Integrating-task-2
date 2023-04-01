package model;

import java.util.Calendar;

// re formular 
public class Stage{
    public static final int NUM_CAPSULS = 50;
    private Capsul[] capsuls;
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

    Para lograr asignar las fechas planeadas se deberá solicitar al usuario la cantidad de meses que se lleva cada etapa (arreglo de cantidad de meses).

    */
    private String name;
    private Calendar planedInitialDate;
    private Calendar planedFinalDate;
    private Calendar realInitialDate;
    private Calendar realFinalDate;
    private boolean isActive;
    

    public Stage(String name, boolean isActive,Calendar planedInitialDate,Calendar planedFinalDate ){
        this.name = name;
        this.isActive = isActive;
        capsuls = new Capsul[NUM_CAPSULS];

    }

 


    // getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
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

   


}