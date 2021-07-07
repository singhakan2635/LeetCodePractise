package Summer.ArarysHashMap;

public class TrappingRainWater
{
    public int trap(int[] height)
    {
        int ans =0;
        if (height.length==0) return ans;
        int left =0;
        int right = height.length-1;
        int left_max =0, right_max=0;

        while (left<right)
        {
            if (height[left]>left_max)
            {
                left_max = height[left];
            }
            if (height[right]>right_max)
            {
                right_max = height[right];
            }

            if (left_max<right_max)
            {
                ans+= Math.max(0, left_max-height[left]);
                left++;
            }
            else
            {
                ans += Math.max(0, right_max-height[right]);
                right--;
            }
        }
        return ans;
    }
}
