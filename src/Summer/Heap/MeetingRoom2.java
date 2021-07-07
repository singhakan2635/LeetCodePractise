package Summer.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2
{
    public int minMeetingRooms(int[][] intervals)
    {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //start time sort
                return o1[0]-o2[0];
            }
        });
        //[[0,30],[10,20],[5,10],[15,20]]
        //[0,30],[5,10],[10,20],[15,20]
        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        heap.offer(intervals[0]);
        for (int i=1;i<intervals.length;i++)
        {
            int[] interv = heap.poll();
            if (intervals[i][0]>=interv[1])
            {
                interv[1] = intervals[i][1];
            }
            else
            {
                heap.offer(intervals[i]);
            }
            heap.offer(interv);
        }
        return heap.size();



    }
    public int minMeetingRooms2(int[][] intervals)
    {
        int[] start= new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i=0;i<intervals.length;i++)
        {
            start[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(ends);

        int rooms=0, endItr=0;

        for (int i=0;i< start.length;i++)
        {
            if (start[i]<ends[endItr])
            {
                rooms++;
            }
            else
            {
                endItr++;
            }
        }
        return rooms;
    }


}
