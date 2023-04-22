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
                System.out.println("Select option");
                option= view.input.nextInt();
            }while( !(option >= 0 && option<=10) );

            view.executeOption(option);

        }while(option != 0);


        
        view.input.close();
    }
    
    /**
     * This method shows the menu
     */

    // menu
    /*
    

    1 si-si
    2 si-si
    3 si-si
    4 si-si
    5 si-si
    6 si-si
    7 si- si
    8 si- si
    9 si - si
    10 si - si (falta 1 condicion)

    */
    public void menu(){
        System.out.println("\n0. Exit\n" +
                    "1. Create project \n"+
                    "2. Register capsule\n"+
                    "3. Approve capsule\n"+
                    "4. Publish capsule\n"+
                    "5. Complete a stage of a project\n" +
                    "6. Show how many capsules are registered for each type of capsule\n"+

                    "7. List the lessons learned of a project for a particular stage\n"+

                    "8. Give the name of the project with the most capsules recorded\n"+

                    "9. Inform if a collaborator (by name) has registered capsules in any project.\n" +

                    "10. Search lessons by key words in approved and published capsules\n"
                    
                    
                    );



    }
    
    /** 
     * 
     * @param option
     * 
     */
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
            case 6:
                showNumOfEveryCapsuleType();
				break;
            case 7:
                listLessonsLearnedOfProjectForAStage();
				break;
            case 8:
                getNameOfTheProjectWithMoreCapsules();
				break;
            case 9:
                checkCollaboratorsCapsulesInProjects();
				break;
            case 10:
                searchLessonByKeyWords();
				break;
		}

	}

    // Case 1
    /**
     * This method allows to create a project
    */

    public void createProject(){

        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("Enter project name");
        String projectName = input.nextLine();

        System.out.println(projectName);

        System.out.println("\nEnter client name");
        String clientName = input.nextLine();

        System.out.println(clientName);

        System.out.println("\nEnter initial date");
        Calendar initialDate = createdate();
        System.out.println(convDateFormat(initialDate));

        // calculate planned dates
        Calendar date = initialDate ;
        
    
        System.out.println("\nEnter start stage duration (months)");
        int stageDurationInMonths0 = input.nextInt();

        Calendar planedInitialDate0 = initialDate;

        Calendar planedFinalDate0 = addMonths(date, stageDurationInMonths0);
        System.out.println("\nThis stage will last until "+convDateFormat(date));


        System.out.println("\nEnter analysis stage duration (months)");
        int stageDurationInMonths1  = input.nextInt();
        Calendar planedInitialDate1 = planedFinalDate0;
        Calendar planedFinalDate1 = addMonths(date, stageDurationInMonths1);
        System.out.println("\nThis stage will last until "+convDateFormat(date));


        System.out.println("\nEnter design stage duration (months)");
        int stageDurationInMonths2  = input.nextInt();
        Calendar planedInitialDate2 = planedFinalDate1;
        Calendar planedFinalDate2 = addMonths(date, stageDurationInMonths2);
        System.out.println("\nThis stage will last until "+convDateFormat(date));


        System.out.println("\nEnter execution stage duration (months)");
        int stageDurationInMonths3 = input.nextInt();
        Calendar planedInitialDate3 = planedFinalDate2;
        Calendar planedFinalDate3 = addMonths(date, stageDurationInMonths3);
        System.out.println("\nThis stage will last until "+convDateFormat(date));


        System.out.println("\nEnter closure  stage duration (months)");
        int stageDurationInMonths4 = input.nextInt();
        Calendar planedInitialDate4 = planedFinalDate3;
        Calendar planedFinalDate4= addMonths(date, stageDurationInMonths4);
        System.out.println("\nThis stage will last until "+convDateFormat(date));


        System.out.println("\nEnter project control stage duration (months)");
        int stageDurationInMonths5 = input.nextInt();
        Calendar planedInitialDate5 = planedFinalDate4;
        Calendar planedFinalDate5 = addMonths(date, stageDurationInMonths5);
        System.out.println("\nThis stage will last until "+convDateFormat(date));

        Calendar finalDate = planedFinalDate5;

        System.out.println("\nEnter project budget");
        double budget= input.nextDouble();

        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("\nEnter Green SQA project manager name");
        String managerNameG = input.nextLine();

        System.out.println(managerNameG);

        System.out.println("\nEnter Green SQA project manager phone number ");
        String managerNumberG = input.nextLine();

        System.out.println(managerNumberG);

        System.out.println("\nEnter clients project manager name");
        String managerNameC= input.nextLine();

        System.out.println(managerNameC);

        System.out.println("\nEnter clients project manager phone number");
        String managerNumberC= input.nextLine();

        System.out.println(managerNumberC);


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
    /**
     * This method allows to register a capsule
    */

    // add next line in long strings be carefull
    public void registerCapsule(){

        // change to next line
        input.nextLine(); // clean buffer

        // add project validation
        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        System.out.println(searchProjectByName);

        System.out.println("\nEnter a capsule id (must be unique)");
        int id = input.nextInt();
        System.out.println(id);

        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("\nEnter capsule description");
        String capsuleDescription = input.nextLine();
        System.out.println(capsuleDescription);



        int type;

        do{

        System.out.println("Select capsule type:"); 
        System.out.println(" 1. for TECHNICAL");
        System.out.println(" 2. for MANAGEMENT");
        System.out.println(" 3. for DOMAIN");
        System.out.println(" 4. for EXPERIENCES");

        type = input.nextInt();

        }while( !(type>=1 && type<=4));  
        System.out.println(type);

        input.nextLine(); // clean buffer
        
        System.out.println("\nEnter collaborator name");
        String colabName = input.nextLine();
        System.out.println(colabName);
        
        System.out.println("\nEnter collaborator position");
        String colabPosition = input.nextLine();
        System.out.println(colabPosition);
        
        System.out.println("\nEnter lection learned \nKeywords must be between # example #car#");
        String lectionLearned = input.nextLine();
        System.out.println(lectionLearned);

        System.out.println(controller.registerCapsule(searchProjectByName, id, capsuleDescription,type , colabName, 
        colabPosition, lectionLearned ));
        

    }


    // Case 3
    /**
     * This method allows to approve a capsule
     */
    public void approvecapsule(){
        

        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        
        int searchStageByName = -1 ;

        do{
            System.out.println("\nSelect stage by name\n" +
            "1. start \n"+
            "2. analysis\n"+
            "3. design\n"+
            "4. execution\n"+
            "5. closure\n"+
            "6. project control\n");
            searchStageByName= input.nextInt();
        }while( !(searchStageByName>0 && searchStageByName<=6) );

        
        

        System.out.println("\nEnter Capsule id");
        int id = input.nextInt();

        System.out.println(controller.approveCapsule(searchProjectByName, searchStageByName, id));
        
        
    }

    // Case 4
    /**
     * This method allows to publish a capsule
     */
    public void publishCapsule(){


        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        

        int searchStageByName = -1;
        do{
            System.out.println("\nSelect stage by name\n" +
            "1. start \n"+
            "2. analysis\n"+
            "3. design\n"+
            "4. execution\n"+
            "5. closure\n"+
            "6. project control\n");
            searchStageByName= input.nextInt();
        }while( !(searchStageByName>0 && searchStageByName<=6) );

        System.out.println("\nEnter Capsule id");
        int id = input.nextInt();

        System.out.println(controller.publishCapsule(searchProjectByName, searchStageByName, id));
    }

    // Case 5
    /**
     * This method allows to change the stage of a project
     */
    public void changeStage(){

        // change to next line
        input.nextLine(); // clean buffer

        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        System.out.println(controller.changeStage(searchProjectByName));
        
        
    }

    //case 6
    public void showNumOfEveryCapsuleType(){
        input.nextLine(); // clean buffer

        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        

        int searchStageByName = -1;
        do{
            System.out.println("\nSelect stage by name\n" +
            "1. start \n"+
            "2. analysis\n"+
            "3. design\n"+
            "4. execution\n"+
            "5. closure\n"+
            "6. project control\n");
            searchStageByName= input.nextInt();
        }while( !(searchStageByName>0 && searchStageByName<=6) );

        
        System.out.println(controller.showNumOfEveryCapsuleType(searchProjectByName,searchStageByName));




    }


    //case 7
    public void listLessonsLearnedOfProjectForAStage(){
        input.nextLine(); // clean buffer

        System.out.println("\nEnter project name");
        String searchProjectByName = input.nextLine();
        

        int searchStageByName = -1;
        do{
            System.out.println("\nSelect stage by name\n" +
            "1. start \n"+
            "2. analysis\n"+
            "3. design\n"+
            "4. execution\n"+
            "5. closure\n"+
            "6. project control\n");
            searchStageByName= input.nextInt();
        }while( !(searchStageByName>0 && searchStageByName<=6) );
        
        System.out.println(controller.listLessonsLearnedOfProjectForAStage(searchProjectByName, searchStageByName));
    }

    //case 8
    public void getNameOfTheProjectWithMoreCapsules(){

        System.out.println(controller.getNameOfTheProjectWithMoreCapsules());

    }

    //case 9
    public void checkCollaboratorsCapsulesInProjects(){
        input.nextLine(); // clean buffer
        System.out.println("Enter collaborator name");
        String searchCollaboratorNameInCapsules= input.nextLine();
        System.out.println(controller.checkCollaboratorsCapsulesInProjects(searchCollaboratorNameInCapsules));
    }

    //case 10
    public void searchLessonByKeyWords(){
        input.nextLine(); // clean buffer
        String keyword ="";
        System.out.println("Enter keyword");
        keyword = input.nextLine();
        String msg = controller.searchLessonByKeyWords(keyword);
        if(msg != ""){
            System.out.println(msg);
        }
        else{
            System.out.println("No lesson has been found");
        }
        
    }


    
    /** 
     * this method allow create a date with the format type calendar
     * @return Calendar
     */
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


    
    /** 
     * this method converts a calendar type date to a string with the format dd/MM/yyyy
     * @param date
     * @return String
     */
    // change date format
    public String convDateFormat(Calendar date){

		String formatDate = simpleDateFormat.format(date.getTime()) ;
		return formatDate;

	}

    
    /** 
     * this method allows to add months to a calendar type date
     * @param date
     * @param months
     * @return Calendar
     */
    public Calendar addMonths(Calendar date, int months){
		
		date.add(Calendar.MONTH, months); 

		return date;

	}




}





