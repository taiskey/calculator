import java.util.Scanner;
abstract class Start {
    String number1,number2;
    String delimiter = "/";
    String[] subS;
    String[] subS2;
    int n1,n2,l;
    public Start( String number1,String number2){
        this.number1 = number1;
        this.number2 = number2;
        subS = number1.split(delimiter);
        subS2 = number2.split(delimiter);
    }
}
class Numbers extends Start {
    int a[] = new int[4];

    public Numbers(String number1, String number2) {
        super(number1, number2);

        for (int i = 0; i < 2; i++) {
            a[0] = Integer.valueOf(subS[i]);
            i++;

            a[1] = Integer.valueOf(subS[i]);
            i++;
        }
        for (int i = 0; i < 2; i++) {
            a[2] = Integer.valueOf(subS2[i]);
            i++;

            a[3] = Integer.valueOf(subS2[i]);
            i++;
        }
    }
    void Exceptions() {
        if (a[1] == 0 || a[3] == 0) {
            System.out.println("Дробь не существует, так как знаменатель равен 0");
            System.exit(0);
        }
    }
    void Viewer() {
        for (int i = 0; i < 3; i++) {
            n1 = a[i];
            n2 = a[i + 1];
            int l=n1;
            while(true){
                if( n1 % l == 0 && n2 % l ==0)
                    break;
                l--;
            }
            if(n2/l != 1)
                System.out.println(n1/l+"/"+n2/l);
            else
                System.out.println(n1/l);
            i++;
        }
    }
    void addition(){
        if(a[1]==a[3]) {
            n1 = a[0] + a[2];
            n2 = a[1];
        }
        else {
            n1 = a[0]*a[3] + a[2]*a[1];
            n2 = a[1]*a[3];
        }
    }
    void subtraction(){
        if(a[1]==a[3]){
            n1 = a[0] - a[2];
            n2 = a[1];
        }
        else {
            n1 = a[0]*a[3] - a[2]*a[1];
            n2 = a[1]*a[3];
        }
    }
    void multiplication(){
        n1 = a[0]*a[2];
        n2 = a[1]*a[3];
    }
    void segmentation(){
        n1 = a[0]*a[3];
        n2 = a[1]*a[2];
    }
    void result(){
        if(n1 > 0) {
            l = n1;
        }
        else {
            l = n2;
        }
        while(true){
            if( n1 % l == 0 && n2 % l ==0)
                break;
            l--;
        }
        if(n2/l != 1)
            System.out.println(n1/l+"/"+n2/l);
        else
            System.out.println(n1/l);

    }
}


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        String[] operators = {"+","-","*",":"};
        for(String operator:operators) {
            if (s.contains(operator)) {
                String ops = operator;
                String[] split = s.split("\\"+ops);
                Numbers n = new Numbers(split[0], split[1]);
                n.Exceptions();
                if (ops == "+") {
                    System.out.print("Сумма двух дробей: ");
                    n.addition();
                }

                if (ops == "-") {
                    System.out.print("Разность двух дробей: ");
                    n.subtraction();
                }
                if (ops == "*"){
                    System.out.print("Произведение двух дробей: ");
                    n.multiplication();
                }
                if(ops == ":") {
                    System.out.print("Частное двух дробей: ");
                    n.segmentation();
                }
                n.result();
            }
        }

    }
}