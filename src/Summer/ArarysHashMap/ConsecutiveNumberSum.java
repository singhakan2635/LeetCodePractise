package Summer.ArarysHashMap;

public class ConsecutiveNumberSum
{
    public int consecutiveNumbersSum(int n)
    {
        int ans=0;
        for (int i=1;i*(i-1)/2<n;i++)
        {
            if ((n-i*(i+1)/2)%i ==0)
                ans++;
        }
        return ans+1;

    }
}
