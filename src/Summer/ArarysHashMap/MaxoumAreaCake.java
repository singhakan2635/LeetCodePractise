package Summer.ArarysHashMap;

import java.util.Arrays;

public class MaxoumAreaCake
{
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = Maxdifference(horizontalCuts,h);
        long maxV = Maxdifference(verticalCuts,w);

        return (int) ((maxH*maxV) % (Math.pow(10,9)+7));
    }

    private long Maxdifference(int[] cuts, int x)
    {
//        int max=0;
//        for (int i=0;i<cuts.length;i++) {
//            if (i == 0) {
//                max = Math.max(max, cuts[i] - 0);
//            } else if (i == cuts[cuts.length - 1]) {
//                max = Math.max(max, cuts[cuts.length - 1] - (x - 1));
//            } else {
//                max = Math.max(max, cuts[i] - cuts[i - 1]);
//            }
//
//        }
        long max = Math.max(cuts[0],x - cuts[cuts.length-1]);
        for (int i=1;i<cuts.length;i++)
        {
            max = Math.max(max, cuts[i] - cuts[i - 1]);
        }
        return max;
    }
}
