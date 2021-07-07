package Summer.Stack;

import java.util.Stack;

public class ValidParantheses
{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray())
        {
            if (ch=='('|| ch=='{'|| ch=='[')
            {
                stack.push(ch);
            }
            else if (ch==')')
            {
                if (stack.pop()!='(')
                    return false;
            }
            else if (ch=='}')
            {
                if ('{'!=stack.pop())
                    return false;
            }
            else if(ch==']')
            {
                if ('['!= stack.pop())
                    return false;
            }
        }
        return stack.size()==0;

    }
}
