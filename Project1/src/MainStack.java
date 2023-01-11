import java.util.Scanner;

public class MainStack {
    public static void main(String[] args) {
        StackArray mystack = new StackArray(100);
        Scanner scn = new Scanner(System.in);
        System.out.println("Which task you want to do?");
        System.out.println("1- push");
        System.out.println("2- pop");
        System.out.println("3- Print");
        System.out.println("4- Delete middle");
        System.out.println("5- isPalindrome");
        System.out.println("6- exit");
        int digit;
        do {
            System.out.println("");
            System.out.println("Please enter a digit (1-5):");
            digit = scn.nextInt();
            switch (digit) {
                case 1:
                    mystack.howManyPushes();
                    break;
                case 2:
                    System.out.println(mystack.pop());
                    break;
                case 3:
                    mystack.Print();
                    break;
                case 4:
                    mystack.deleteMiddle();
                    break;
                case 5:
                    System.out.println(mystack.isPalindrome());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    break;
            }

        } while (digit != 6);

    }

}


