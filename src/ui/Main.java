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
            view.menu();

        }while(option != 0);


        view.input.close();
    }
    


    // menu
    public void menu(){
        System.out.println("0. Exit");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");


    }
    // 





}



