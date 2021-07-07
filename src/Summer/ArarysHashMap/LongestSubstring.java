package Summer.ArarysHashMap;

import java.util.HashSet;

public class LongestSubstring
{
    public int lengthOfLongestSubstring(String s)
    {
        int maxlength=0;
        int a=0;
        int b= 0;
        HashSet<Character> set = new HashSet<>();
        while(b<s.length())
        {
            char c = s.charAt(b);
           if(!set.contains(c))
           {
               set.add(c);
               b++;
               maxlength = Math.max(maxlength,b-a+1);

           }
           else
           {
               set.remove(s.charAt(a));
               a++;

           }
        }
        return maxlength;

    }

}
