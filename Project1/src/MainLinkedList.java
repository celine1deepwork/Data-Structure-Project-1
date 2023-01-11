import java.util.Scanner;

class MainLinkedList{
    public static void main(String[] args) {
        LinkedList result = new LinkedList();
        LinkedList result2 = new LinkedList();
        Node temp1;
        Node temp2;
        Node node;
        Node node2;
        Node previous;
        int coefficient1 = 9;// poll1
        int degree1 =0;// pol1
        int coefficient2 = 9;// pol2
        int degree2 = 0; // poll2
        int sumCoef;
        int sumDegg;
        int multiCoef;
        int multiDegg;
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        temp1 = l1.first;
        temp2 = l2.first;
        Scanner scn = new Scanner(System.in);
        int n = 9;

        while (coefficient1 != 0) {
            System.out.println("_____________________________________________________________________________");
            System.out.println();
            System.out.println("Enter the coefficient and power of the first polynomial. Type 0 to end the process:");
            System.out.println();


            coefficient1 = scn.nextInt();
            if(coefficient1 == 0){
                System.out.println(0);
                break;
            }
            degree1 = scn.nextInt();
            temp1 = new Node(coefficient1, degree1);// l1's node
            System.out.println(coefficient1 + " " + degree1 + "\n");
            coefficient1 = temp1.coefficient;
            degree1 = temp1.degree;
            l1.insertFirst(temp1);
            // goes until l1 ends up with null ??
            l1.first = temp1;
            //temp1 = temp1.next;

        }
        while (coefficient2 != 0) {
            System.out.println("Enter the coefficient and power of the second polynomial. Type 0 to end the process:");
            coefficient2 = scn.nextInt();
            if(coefficient2 == 0){
                System.out.println(0);
                break;
            }
            degree2 = scn.nextInt();
            temp2= new Node(coefficient2, degree2);
            System.out.println(coefficient2 + " " + degree2 + "\n");
            coefficient2 = temp2.coefficient;
            degree2 = temp2.degree;
            l2.insertFirst(temp2);
            l2.first=temp2;
            //temp2 = temp2.next;

        }
        while (n != 0) {
            System.out.println("Which task you want to do ? ");
            System.out.println();
            System.out.println("1- Add \n 2- Multiply \n 3- Print \n 4- Delete \n 5- Exit ");
            System.out.println("Please enter a digit (1-5)");
            n = scn.nextInt();


            if (n == 2) {
                temp1 = l1.first;
                while (temp1 != null) {
                    temp2 = l2.first;
                    while (temp2 != null) {
                        multiCoef = temp1.coefficient * temp2.coefficient;
                        multiDegg = temp1.degree + temp2.degree;
                        node = new Node(multiCoef, multiDegg);
                        result2.insertFirst(node);
                        temp2 = temp2.next;
                    }
                    temp1 = temp1.next;
                }

                temp1 = result2.first;
                while (temp1 != null) {
                    temp2 = temp1.next; // temp1 ilerledikce temp2 de ilerlesin diye
                    while (temp2 != null ) { // if there is more than one same degreed node, their coef's would be added
                        if(temp1.degree == temp2.degree){
                            temp2.coefficient += temp1.coefficient;
                            int k  = result2.findIndexNode(temp1);
                            result2.deleteNode(k); // temp1 in eski konumunu sileeriz.

                        }
                        temp2 = temp2.next; //
                    }
                    temp1 = temp1.next; // temp1'in değeri temp2'nin eski konumu olduğu için first'ü temp2 oldu. temp2 de bir yana kaydı
                }
                result2.getList();


            }

            if (n == 3) {
                System.out.println(" Print a polynomial ");
                System.out.println("The polinomials are : ");
                System.out.println();
                l1.getList();
                System.out.print ( " and ");
                l2.getList();
                System.out.println();

                if (l1 == null && l2 == null) {
                    System.out.println("Lists are empty");
                    break;
                }

            }
            if (n == 4) {
                System.out.println(" Remove a node with a given power from polynomial ");
                System.out.println();
                System.out.println("Which power you want to be delete from both polynomials:");
                int p = scn.nextInt();
                while(temp1 != null || temp2 != null){

                    if (p == temp1.degree) {
                        int a = l1.findIndexNode(temp1);
                       l1.deleteNode(a);
                    }
                    if (p == temp2.degree) {
                        int b = l2.findIndexNode(temp2);
                        l2.deleteNode(b);
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }

                if(l1 == null && l2 == null) {
                    System.out.println("This power does not exist in any polynomial.");
                    System.out.println("Lists are empty.");
                }
                System.out.println("Delete process is done. ");
                l1.getList();
                System.out.print( " and ");
                l2.getList();

            }
            if (n == 5) {
                System.out.println("EXIT ");
                l1 = null;
                l2 = null;

                break;

            }

        }

    }
}
