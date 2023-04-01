package model;

import java.util.Calendar;

public class Project {
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
    String managerNameG,String managerNumberG, String managerNameC,String managerNumberC ){

        this.projectName = projectName;	
		this.clientName = clientName;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.budget = budget;

		this.managerNameG = managerNameG;
        this.managerNumberG = managerNumberG;
        this.managerNameC = managerNameC;
        this.managerNumberC = managerNumberC; 
    }

    // get
    public String getprojectName(){
        return projectName;

    }
    
}
