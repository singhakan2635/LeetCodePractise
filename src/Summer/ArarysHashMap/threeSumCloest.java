package Summer.ArarysHashMap;

import java.util.Arrays;

public class threeSumCloest
{
    public int threeSumClosest(int[] nums, int target)
    {
        int minVal = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0;i+2<nums.length;i++)
        {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1, k= nums.length-1;
            while (j<k)
            {
                int current_sum = nums[i]+nums[j]+nums[k];
                if (current_sum>target)
                {
                    k--;
                }
                else
                    j++;
                if (Math.abs(target-current_sum)<Math.abs(target-minVal))
                {
                    minVal=target;
                }
            }
        }
        return minVal;

    }
}
