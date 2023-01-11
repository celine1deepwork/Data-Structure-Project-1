import java.util.Scanner;

/**
 *
 * @author asus
 */
public class StackArray {

    String data[]; //array to hold items
    int top;       //the top most item index

    public StackArray(int N) {
        data = new String[N];
        top = -1;
    }

    public void push(String element) {
        if (!isFull()) {
            top++;
            data[top] = element;
        }
    }

    public int size() {
        return this.top + 1;
    }

    public void howManyPushes() {

        Scanner scn = new Scanner(System.in);
        System.out.println("How many pushes you want to do?");
        int num = scn.nextInt();
        if (num == 0) {
            return;
        }
        System.out.println("Enter " + num + " strings:");
        for (int i = 0; i < num; i++) {
            String s = scn.next();
            this.push(s);

        }

    }

    public boolean isPalindrome() {

        StackArray tmp = new StackArray(100);

        if (this.top == 0) {
            return true;
        }

        if (isEmpty()) { //Exception mı vermeliyim yoksa uyarıp kodu devam mı ettirmeliyim.
            System.out.println("There is no elementin the stack!!");
            return false;
            //throw new java.util.NoSuchElementException();
        }

        int n = size();
        String str1 = "";
        String str2 = "";
        boolean palindrome = true;
        for (int i = 0; i < n / 2; i++) {// her elemean için yapıcaz bu işi. Middle element dahil değil zaten gerek de yok.

            for (int j = 0; j <= i; j++) { //Simetri 1'deki değer.
                if (j != i) {
                    String s = this.pop();
                    tmp.push(s);
                }
                if (j == i) {
                    str1 = this.pop();
                    tmp.push(str1);
                }
            }

            while (!tmp.isEmpty()) {
                this.push(tmp.pop());
            }

            for (int j = 1; j <= n - i; j++) { //Simetri 2'deki değer.
                if (j != n - i) {
                    tmp.push(this.pop());
                }
                if (j == n - i) {
                    str2 = this.pop();
                    tmp.push(str2);
                }
            }

            while (!tmp.isEmpty()) {
                this.push(tmp.pop());
            }

            palindrome = str1.equals(str2);

            if (palindrome == false) {
                return palindrome;
            }
        }
        return palindrome;
    }

    public void deleteMiddle() {//7 ve 7 den fazla element olunca sorun oluyor.

        int count = 0;
        int n = this.size();
        StackArray tmpStack = new StackArray(this.size());
        if ((size() % 2 == 0)) {
            System.out.println("There is no middle element!");
        } else if (size() == 1) {
            System.out.println("There is only one element in the stack!!");
        } else {
            while (count < (n / 2)) {
                tmpStack.push(this.pop());
                count++;
            }

            this.pop();

            while (!tmpStack.isEmpty()) {
                String x = tmpStack.pop();
                this.push(x);
            }
        }

    }

    public String pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            top--;//önce return edip sonra top-- yapsam yine çalışır mı acaba.
            return data[top + 1];
        }
    }

    public void Print() {

        StackArray tmpStack = new StackArray(this.top + 1);

        while (!this.isEmpty()) {
            String s = this.pop();
            System.out.println(s + " ");
            tmpStack.push(s);
        }
        while (!tmpStack.isEmpty()) {
            this.push(tmpStack.pop());
        }

    }

    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
