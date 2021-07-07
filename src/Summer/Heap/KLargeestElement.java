package Summer.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargeestElement
{
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int x: nums)
        {
            heap.offer(x);
        }
        int res =0;
        while(k-->0)
        {
            res = heap.poll();
        }
        return res;

    }
}
