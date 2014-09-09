import java.util.Random;
import java.util.Scanner;

public class CalcMediana
{

    static int N;
    static int [] masOne;
    static int [] masTwo;

    CalcMediana()
    {


        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        masOne = new int[N];
        masTwo = new int[N];

    }

    public void findMediana(int [] a)
    {
        System.out.println((a[N-1]+a[N])/2);
    }

    public static int [][] fillMass(int [] a, int [] b)
    {
        Random rand = new Random();

        for (int i=0; i<N; i++) {
            a[i] = rand.nextInt(100);
            b[i] = rand.nextInt(100);
        }


        int [][] result = new int[2][N];
        result[0] = a;
        result[1] = b;

        return result;

    }

    public static int[] mergeSort(int [] list)
    {
        if (list.length <= 1)
        {
            return list;
        }


        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);


        mergeSort(first);
        mergeSort(second);


        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int [] result)
    {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length)
        {
            if (first[iFirst] < second[iSecond])
            {
                result[j] = first[iFirst];
                iFirst++;
            } else
            {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

    public static void main(String args[])
    {

        CalcMediana cm = new CalcMediana();

        int [][] sortMas = new int [2][N];
        sortMas = fillMass(masOne, masTwo);

        sortMas[0] = mergeSort(sortMas[0]);
        sortMas[1] = mergeSort(sortMas[1]);

        for (int i=0; i<N; i++)
            System.out.print(sortMas[0][i] + " ");

        System.out.print('\n');

        for (int i=0; i<N; i++)
            System.out.print(sortMas[1][i] + " ");

        System.out.print('\n');
        System.out.print('\n');

        int[] result = new int [2*N];
        merge(sortMas[0],sortMas[1], result);

        for (int i=0; i<N*2; i++)
            System.out.print(result[i] + " ");

        System.out.print('\n');
        System.out.print('\n');

        cm.findMediana(result);



    }


}
