package Summer.dp;

public class BestTimeToBuynSell
{
    public int maxProfit(int[] prices)
    {
        int maxprofit=0;
        int minPrice = Integer.MIN_VALUE;

        for (int i=0;i<prices.length;i++)
        {
            if (prices[i]<minPrice)
            {
                minPrice = prices[i];
            }
            else if (prices[i]-minPrice>maxprofit)
            {
                maxprofit = Math.max(maxprofit,prices[i]-minPrice);
            }
        }


        return maxprofit;

    }
}
