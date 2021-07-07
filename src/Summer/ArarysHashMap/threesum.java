package Summer.ArarysHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i+2< nums.length;i++)
        {
            if ( i>0 && nums[i]==nums[i-1])
                continue;
            if (nums[i]>0)
                break;
            int target = -nums[i];

            int j=i+1, k= nums.length-1;
            while (j<k)
            {
                if (nums[j]+nums[k]==target)
                {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                    while (j<k && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }

                else if (nums[j]+nums[k]>target)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
    return res;
    }
}
