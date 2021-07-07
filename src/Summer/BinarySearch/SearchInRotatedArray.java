package Summer.BinarySearch;

public class SearchInRotatedArray
{
    public int search(int[] nums, int target)
    {
        return BinarySearch(nums,target,0, nums.length-1);

    }

    private int BinarySearch(int[] nums, int target, int left, int right)
    {
        while(left<=right)
        {
            int mid = (left + right)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]>=nums[left])
            {
                if (nums[left]<=target && nums[mid]>target)
                {
                    right = mid;
                }
                else
                {
                    left = mid+1;
                }
            }
            else
            {
                if (nums[right]>=target && nums[mid]<target)
                {
                    left = mid+1;
                }
                else
                {
                    right = mid;
                }
            }

        }
        return -1;
    }
}
