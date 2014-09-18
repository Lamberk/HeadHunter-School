import java.util.Scanner;

public class Finder
{
    static String a;
    static int N;

    Finder()
    {
        Scanner scan = new Scanner(System.in);
        a = scan.nextLine();
        N = a.length();
    }

    public String createMas(int length)
    {
        String result = new String();

        for (int i=1; i<length+1; i++)
            result = result + String.valueOf(i);

        return result;
    }

    public int toLook(String mas1, String mas2, int length)
    {
        if (mas1.compareTo(mas2)==0) return 1;

        String nextNumber;
        String firstNumber;

        int count = 1;
        int flag = 1;
        int first = 1;
        int test = length + 1;
        nextNumber = String.valueOf(test);
        firstNumber = String.valueOf(first);
        while(true)
        {

            count++;
            if (flag == 0) break;

            while(!nextNumber.isEmpty())
            {
                mas2 = mas2.substring(1) + nextNumber.charAt(0);
                nextNumber = nextNumber.substring(1);

                if (firstNumber.isEmpty()== true && nextNumber.isEmpty()==false) count++;
                if (firstNumber.isEmpty() == false)firstNumber = firstNumber.substring(1);


                System.out.println(nextNumber);
                System.out.println(mas1);
                System.out.println(mas2);
                System.out.println(count);
                System.out.println('\n');



                flag = mas1.compareTo(mas2);

            }

            length++;
            first++;
            nextNumber = String.valueOf(length);
            firstNumber = String.valueOf(first);
        }

        return count;

    }

    public static void main(String args[]){

        Finder finder = new Finder();
        System.out.println(finder.toLook(a,finder.createMas(N),N));

    }
}
