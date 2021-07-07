package Summer;

public class LongestPalindromicSubstring
{
    public String longestPalindrome(String s)
    {
        String longest="", odd ="", even ="";
        for (int i=0;i<s.length();i++)
        {
            odd = helper(i,i,s);
            even = helper(i,i+1,s);
            if (longest.length()<odd.length())
            {
                longest=odd;
            }
            if (longest.length()<even.length())
            {
                longest = even;
            }
        }
        return longest;

    }
    public String helper(int i, int j, String s)
    {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
