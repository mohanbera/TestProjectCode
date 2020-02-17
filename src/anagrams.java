import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class anagrams
{
    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);

        int num1=r.nextInt();

        String[] strArr1=new String[num1];
        for(int i=0;i<num1;i++)
        {
            strArr1[i]=r.next();
        }

        int[][] arr1=anagrams(strArr1);

        for(int[] arrA : arr1)
        {
            for(int numA : arrA)
            {
                System.out.print(numA+" ");
            }
            System.out.println();
        }
    }

    // Here I am sorting the String ex:  "cat tac act" will generate the same string which is "act" after sorting
    public static String sorted(String strA)
    {
        char[] chars=strA.toCharArray();
        int lenOfChars=strA.length();
        Arrays.sort(chars);
        StringBuilder strB= new StringBuilder();
        for(int i=0;i<lenOfChars;i++)
        {
            strB.append(chars[i]);
        }

        return strB.toString();
    }
    public static int[][] anagrams(final String[] A)
    {
        int lenA=A.length;

        // Hasmap to store the index int their corresponding list
        HashMap<String, ArrayList<Integer>> storingMap=new HashMap<String, ArrayList<Integer>>();

        for(int i=0;i<lenA;i++)
        {
            String curStr=A[i];
            String itsSortedForm=sorted(curStr);

            if(storingMap.containsKey(itsSortedForm))
            {
                ArrayList<Integer> arrayList=storingMap.get(itsSortedForm);
                arrayList.add(i+1);
                storingMap.put(itsSortedForm, arrayList);
            }
            else
            {
                ArrayList<Integer> arrayList=new ArrayList<Integer>();
                arrayList.add(i+1);
                storingMap.put(itsSortedForm, arrayList);
            }
        }


        // Rest all the code is only for converting the lists of the string positions into 2d array
        int numberOfuniqString = storingMap.size();
        int[][] resArr=new int[numberOfuniqString][];

        int pos1=0;
        for(int i=0;i<lenA;i++)
        {
            String curStr=A[i];
            String itsSortedStr=sorted(curStr);
            if(storingMap.containsKey(itsSortedStr))
            {
                ArrayList<Integer> listA=storingMap.get(itsSortedStr);
                int itsCount=listA.size();
                int[] arr1=new int[itsCount];

                int index=0;
                for(int nums : listA)
                {
                    arr1[index++]=nums;
                }

                resArr[pos1++]=arr1;
                storingMap.remove(itsSortedStr);
            }
        }
        return resArr;
    }
}
