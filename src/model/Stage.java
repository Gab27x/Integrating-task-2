package model;
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
    6.	seguimiento 
    7.	control del proyecto

    Cada etapa tendrá una fecha de inicio y fin (planeada) y una fecha de inicio y fin (real).
    solo la etapa de inicio queda activa. 

    Para lograr asignar las fechas planeadas se deberá solicitar al usuario la cantidad de meses que se lleva cada etapa (arreglo de cantidad de meses).

    */
    private String name;

    public Stage(String name){
        this.name = name;
        capsuls = new Capsul[NUM_CAPSULS];

    }

   


}