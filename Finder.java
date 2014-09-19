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


        int flag = 1;
        int coreCount = length + 1;

        int result = 1;
        nextNumber = String.valueOf(coreCount);
        while(true)
        {

            if (flag == 0) break;

            while ((!nextNumber.isEmpty()))
            {
                mas2 = mas2.substring(1) + nextNumber.charAt(0);
                nextNumber = nextNumber.substring(1);

                result++;

                flag = mas1.compareTo(mas2);
                if (flag==0) break;
            }

            coreCount++;

            nextNumber = String.valueOf(coreCount);
        }

        return result;
    }

    public static void main(String args[]){

        Finder finder = new Finder();
        System.out.println(finder.toLook(a,finder.createMas(N),N));
    }
}
