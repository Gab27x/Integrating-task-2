package ui;
import model.Controller;
import java.util.Scanner;


public class Main {
    private Scanner input;
    private Controller controller;

    public Main(){
        input = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[]args){      
        Main view = new Main();
        int option = 0 ;
        do{
            do{
                view.menu();
                option= view.input.nextInt();
            }while( !(option >= 0 && option<=6) );


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
    // 





}



