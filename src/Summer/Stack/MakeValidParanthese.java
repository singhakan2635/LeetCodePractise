package Summer.Stack;

import java.util.*;

public class MakeValidParanthese
{
    public String minRemoveToMakeValid(String s)
    {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

       for (int i=0;i<s.length();i++)
       {
           if (s.charAt(i)=='(')
           {
               stack.push(i);
           }
           if (s.charAt(i)==')')
           {
                if (stack.isEmpty())
                {
                    set.add(i);
                }
                else
                {
                    stack.pop();
                }
           }
       }
       while (!stack.isEmpty())
       {
           set.add(stack.pop());
       }
       StringBuilder sb = new StringBuilder();

       for (int i=0;i<s.length();i++)
       {
           if (!set.contains(i))
           {
               sb.append(s.charAt(i));
           }
       }
       return sb.toString();

    }
}
