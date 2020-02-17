import java.util.Scanner;
import java.util.Stack;

public class braces
{
    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);
        String str1=r.nextLine();

        System.out.println(braces(str1));
    }

    public static int braces(String A)
    {
        // removing all spaces
        A=A.replaceAll(" ","");

        Stack<Character> stack=new Stack<Character>();

        int lenA=A.length();

        int res1=0;

        me1: for(int i=0;i<lenA;i++)
        {
            char chr1=A.charAt(i);

            // if ')' occurs then we are finding its corresponding '(' which is stored in the stack
            if(chr1==')')
            {
                // if the peek elements is '(' then inside '(' & ')' there was no elements so it was unnecessary to use '()'
                if(stack.peek() == '(')
                {
                    res1=1;
                    break me1;
                }
                else
                {
                    // if there the peek element is not '(' that means there was other elements like 'a' or 'b' or '+' inside the braces
                    // we are removing those elements until we found its corresponding '('
                    int countOfOther=0;
                    while (stack.peek()!='(')
                    {
                        stack.pop();
                        countOfOther++;
                    }

                    // and we are counting how many elements are inside it if only one element is inside it then it is unnecessary
                    // like '(a)'  we can simply write 'a'  or '(a)+(b)' we can write 'a+b' so these are unnecessary
                    if(countOfOther==1)
                    {
                        res1=1;
                        break me1;
                    }
                    stack.pop();
                }
            }
            else
            {
                stack.push(chr1);
            }
        }

        return res1;
    }
}
