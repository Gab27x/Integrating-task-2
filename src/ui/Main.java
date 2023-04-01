package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Controller;

import java.text.SimpleDateFormat;

public class Main {
    private Scanner input;
    private Controller controller;
    private SimpleDateFormat simpleDateFormat;

    public Main(){
		input = new Scanner(System.in);
		controller = new Controller();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static void main(String[]args){      
        Main view = new Main();
        int option = 0 ;
        do{
            do{
                view.menu();
                option= view.input.nextInt();
            }while( !(option >= 0 && option<=6) );

            view.executeOption(option);

        }while(option != 0);


        view.input.close();
    }
    


    // menu
    public void menu(){
        System.out.println("\n0. Exit\n" +
                    "1. Create project \n"+
                    "2. Register capsule\n"+
                    "3. Approve capsule\n"+
                    "4. Publish capsule\n"+
                    "5. Complete a stage of a project\n" );



    }
    // executeOption 
    public void executeOption(int option){
		switch(option){
			case 0:
			    System.out.println("Exit");
				break;
			case 1:
                createProject();
				break;
			case 2:
                registerCapsule();
				break;
			case 3:
			    approvecapsule();
				break;
            case 4:
                publishCapsule();
				break;
            case 5:
                changeStage();
				break;
		}

	}

    // Case 1
    public void createProject(){

        System.out.println("Enter project name");
        String projectName = input.next();
        
        System.out.println("Enter client name");
        String clientName= input.next();

        System.out.println("Enter initial date");
        Calendar initialDate = createdate();

        // calculate planned dates

        Calendar date = initialDate ;
    
        System.out.println("Enter start stage duration (months)");
        int stageDurationInMonths0 = input.nextInt();

        Calendar planedInitialDate0 = initialDate;
        Calendar planedFinalDate0 = addMonths(date, stageDurationInMonths0);

        System.out.println("Enter analysis stage duration (months)");
        int stageDurationInMonths1  = input.nextInt();
        Calendar planedInitialDate1 = planedFinalDate0;
        Calendar planedFinalDate1 = addMonths(date, stageDurationInMonths1);


        System.out.println("Enter design stage duration (months)");
        int stageDurationInMonths2  = input.nextInt();
        Calendar planedInitialDate2 = planedFinalDate1;
        Calendar planedFinalDate2 = addMonths(date, stageDurationInMonths2);


        System.out.println("Enter execution stage duration (months)");
        int stageDurationInMonths3 = input.nextInt();
        Calendar planedInitialDate3 = planedFinalDate2;
        Calendar planedFinalDate3 = addMonths(date, stageDurationInMonths3);


        System.out.println("Enter closure  stage duration (months)");
        int stageDurationInMonths4 = input.nextInt();
        Calendar planedInitialDate4 = planedFinalDate3;
        Calendar planedFinalDate4= addMonths(date, stageDurationInMonths4);


        System.out.println("Enter  project control stage duration (months)");
        int stageDurationInMonths5 = input.nextInt();

        Calendar planedInitialDate5 = planedFinalDate4;
        Calendar planedFinalDate5 = addMonths(date, stageDurationInMonths5);

        Calendar finalDate = planedFinalDate5;

        System.out.println("Enter project name");
        double budget= input.nextDouble();

        System.out.println("Enter project name");
        String managerNameG = input.next();

        System.out.println("Enter project name");
        String managerNumberG = input.next();

        System.out.println("Enter project name");
        String managerNameC= input.next();

        System.out.println("Enter project name");
        String managerNumberC= input.next();





        controller.createProject(projectName, clientName, initialDate, finalDate, budget,
        managerNameG, managerNumberG,  managerNameC, managerNumberC,
        planedInitialDate0 , planedFinalDate0
        , planedInitialDate1 , planedFinalDate1
        , planedInitialDate2 , planedFinalDate2
        , planedInitialDate3 , planedFinalDate3
        , planedInitialDate4 , planedFinalDate4
        , planedInitialDate5 , planedFinalDate5
        );
        

        
    }

    // Case 2
    public void registerCapsule(){


        
    }

    // Case 3
    public void approvecapsule(){


        
    }

    // Case 4

    public void publishCapsule(){


        
    }

    // Case 5
    public void changeStage(){


        
    }



    // create a date
    public Calendar createdate(){
        Calendar newDate =  Calendar.getInstance();

        System.out.println("Enter year:");
        int year = input.nextInt();
        
        System.out.println("Enter el month (1-12):");
        int month = input.nextInt() - 1; 
        
        System.out.println("Enter day of the month:");
        int day = input.nextInt();
        
        newDate= Calendar.getInstance();
        newDate.set(year, month, day); 

        return newDate;
    
    }


    // change date format
    public String convDateFormat(Calendar date){

		String formatDate = simpleDateFormat.format(date.getTime()) ;
		return formatDate;

	}
    public Calendar addMonths(Calendar date, int months){
		
		date.add(Calendar.MONTH, months); 

		return date;

	}



}



