package Summer.ArarysHashMap;

import java.util.HashMap;

public class VerifyingAlieanDisctinary
{
    public boolean isAlienSorted(String[] words, String order)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int ch=0;ch<order.length();ch++)
        {
            map.put(order.charAt(ch), ch);
        }
        for (int i=0;i<words.length-1;i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];


            for (int j=0;j<s1.length();j++)
            {
                if(j>=s2.length())
                {
                    return false;
                }
                if(s1.charAt(j)!=s2.charAt(j))
                {
                    if (map.get(s1.charAt(j))>map.get(s2.charAt(j)))
                    {
                        return false;
                    }
                    else break;
                }

            }

        }
        return true;

    }
}
