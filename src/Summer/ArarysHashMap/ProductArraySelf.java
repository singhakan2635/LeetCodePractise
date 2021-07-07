package Summer.ArarysHashMap;

import java.util.Arrays;

public class ProductArraySelf
{
    public int[] productExceptSelf(int[] nums)
    {
        int left=1;
        int[] arr2 = new int[nums.length];
        for (int i=1;i<nums.length;i++)
        {
            left *= nums[i-1];
            arr2[i] = left;

        }
        System.out.println("Arr2 - "+ Arrays.toString(arr2));
        int right=1;
        for (int i=nums.length-2;i>=0;i--)
        {
            right *= nums[i+1];

            arr2[i] *= right;
        }
        return arr2;

    }
}
