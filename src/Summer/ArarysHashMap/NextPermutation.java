package Summer.ArarysHashMap;

import java.util.Arrays;

public class NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        int inverse_point = nums.length-2;
        while (inverse_point>=0 && nums[inverse_point]>=nums[inverse_point+1])
        {
            inverse_point--;
        }
        if (inverse_point>=0)
        {
            for (int i= nums.length-1;i>=inverse_point;i--)
            {
                if (nums[inverse_point]<nums[i])
                {
                    swap(nums,inverse_point,i);
                    break;
                }
            }
        }
        reverse(nums,inverse_point+1);
    }

    private void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void reverse(int[] nums, int start)
    {
        int n =nums.length-1;
        while (start<n)
        {
            swap(nums,start,n);
            start++;
            n--;
        }
    }
}
