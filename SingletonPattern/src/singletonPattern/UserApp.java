package singletonPattern;

import java.util.Queue;
import java.util.Scanner;

public class UserApp 
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) 
        {
                QueueApp queueApp = QueueApp.getInstance();
                boolean exit = false;
                Queue<String> queueList = queueApp.getQueueList();

                while (!exit)
                {
                    System.out.println("Welcome to the Pag-ibig Office!\nLog-in here!\n[1] Customer\n[2] Help Desk\n[0] Exit");
                    System.out.print("Select: ");

                    int office = input.nextInt();
                    input.nextLine();

                    switch (office)
                    {
                        case 0: exit = true;
                                break;
                        case 1: boolean exit1 = false;
                                while (!exit1)
                                {
                                    System.out.println("Hello, user!");
                                    System.out.println("[1] Join queue\n[2] See queue\n[0] Exit");

                                    System.out.print("Select: ");
                                    int queueAction = input.nextInt();
                                    input.nextLine();

                                    switch (queueAction)
                                    {
                                        case 0: exit1 = true;
                                                break;
                                        case 1: System.out.print("Enter name: ");
                                                String name = input.nextLine();
                                                queueApp.addToQueue(name);

                                                System.out.println(name + ", you are number " + queueApp.getCurrentQueueNumber() +".");
                                                break;

                                        case 2: System.out.println("Current queue: ");
                                                int position = 1;
                                                for (String queued : queueList) 
                                                {
                                                        System.out.println(position + ". " + queued);
                                                        position++;
                                                }
                                                break;
                                    }
                                }
                                break;
                                
                        case 2: boolean exit2 = false;
                                while(!exit2)
                                {
                                    System.out.println("Hello, help desk!");
                                    System.out.println("Choose desk:\n[1] Help Desk 1\n[2] Help Desk 2\n[3] Help Desk 3\n[0] Exit");

                                    System.out.print("Select: ");
                                    int helpDeskChooser = input.nextInt();
                                    input.nextLine();
                                    
                                    switch (helpDeskChooser)
                                    {
                                        case 0: exit2 = true;
                                                break;
                                        default: boolean exit3 = false;
                                                 while (!exit3)
                                                 {
                                                    System.out.println("Hello, Help Desk " + helpDeskChooser + "!");
                                                    System.out.println("Choose queue action:\n[1] Call next in line\n[2] Reset queue\n[0] Exit");
                                                    System.out.print("Select: ");
                                                    int queueCall = input.nextInt();
                                                    input.nextLine();

                                                    switch (queueCall)
                                                    {
                                                        case 0: exit3 = true;
                                                                break;
                                                        case 1: if (!queueList.isEmpty())
                                                                {
                                                                        String nowServing = queueList.poll();
                                                                        System.out.println("Now serving: " + nowServing + ".");
                                                                }
                                                                else
                                                                {
                                                                        System.out.println("Queue is empty.");
                                                                }
                                                                break;
                                                        case 2: queueList.clear();
                                                                System.out.println("Queue reset!");
                                                                break;
                                                    }
                                                 }
                                                
                                    }
                                }
                                break;
                    }
                }
        }
        
    }
}