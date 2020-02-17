
import java.util.*;


public class ThreeElementsSum {
    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);

        // length of the array
        int len=r.nextInt();

        // require sum
        int sum=r.nextInt();

        // initializing the array
        int[] arr1=new int[len];
        for(int i=0;i<len;i++)
        {
            arr1[i]=r.nextInt();
        }

        // calling the function for result
        int result=threeSumClosest(arr1, sum);

        System.out.println(result);
    }

    public static int threeSumClosest(int[] A, int B)
    {

        // array length
        int lenA=A.length;

        // sorting the array to reduce the complexity sorting complexity is n log(n)
        Arrays.sort(A);

        // here initializing the requireSum with some dummy value -1
        int requireSum=-1;

        // here I am initializing minDif for getting the difference between the result sum I am getting,
        // less difference means the sum is more closer to the require sum
        int minDif=Integer.MAX_VALUE;
        int curDif=Integer.MAX_VALUE;

        // Visiting all the elements
        me1: for(int i=0;i<lenA-2;i++)
        {
            int right = lenA-1;
            int left = i+1;

            // getting the two sum and adding with the current value to get the three sum
            while (left<right)
            {
                int curSum=A[i] + A[left] + A[right];
                if(curSum == B)
                {
                    // if we get the same sum as require sum then we don't need to visit other elements and break
                    requireSum=B;
                    break me1;
                }
                else if(curSum < B)
                {
                    // checking the difference with the min difference we got still now if it is less then the current sum is more
                    // closure to require sum
                    curDif = B-curSum;

                    if(curDif < minDif)
                    {
                        minDif = curDif;
                        requireSum = curSum;
                    }

                    // it is giving me shorter sum so we will do left++ because the righter elements are bigger in the sorted array
                    // so sum will increase
                    left++;
                }
                else
                {
                    curDif = curSum-B;
                    if(curDif<minDif)
                    {
                        minDif = curDif;
                        requireSum = curSum;
                    }

                    //it is giving me bigger sum so we will do right-- because the lefter elements are smaller so sum will decrease
                    right--;
                }
            }
        }

        return requireSum;
    }
}