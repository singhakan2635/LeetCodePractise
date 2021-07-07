package Summer.ArarysHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals
{
    public int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();

        int[] iter0 = intervals[0];

        res.add(iter0);
        for (int[] interv : intervals)
        {
            if (iter0[1]>= interv[0])
            {
                iter0[1] = Math.max(interv[1],iter0[1]);
            }
            else
            {
                iter0 = interv;
                res.add(iter0);
            }
        }
        System.out.println("Test - "+res);
        return res.toArray(new int[res.size()][2]);

    }

//    class intervals implements Comparator<int[]>
//    {
//
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            return o1[0]-o2[0];
//        }
//    }

}
