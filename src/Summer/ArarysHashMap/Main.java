package Summer.ArarysHashMap;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
//        TwoSum
//        TwoSum twoSum = new TwoSum();
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;
//
//        int[] result = twoSum.twoSum(nums,target);
//
//        System.out.println(Arrays.toString(result));

        //RoboutBoundedBuCircle
        RobotBoundByCircle robotBoundByCircle = new RobotBoundByCircle();
        String ins = "GGLLGG";
        boolean res = robotBoundByCircle.isRobotBounded(ins);
        System.out.println(res);

        //MergeIntervals
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] results = mergeIntervals.merge(intervals);
        for (int[] arr: results)
        {
            System.out.println(Arrays.toString(arr));
        }


    }
}
