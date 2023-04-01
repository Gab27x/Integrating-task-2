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
        
        System.out.println("Enter project name");
        String clientName= input.next();

        System.out.println("Enter project name");
        Calendar initialDate = createdate();

        System.out.println("Enter project name");
        Calendar finalDate= createdate();;

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



        controller.createProject(projectName,clientName,initialDate,finalDate,
        budget,managerNameG,managerNumberG,managerNameC,managerNumberC);
        
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



}



