package Summer.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kcloestetoorigin
{
    public int[][] kClosest(int[][] points, int K)
    {
        int[][] res = new int[K][];
        PriorityQueue<int[]> heap = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0] + o1[1]*o1[1])- (o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });

        for (int[] point: points)
        {
            heap.offer(point);
        }
        for (int i=0;i<K;i++)
        {
            int[] newRes = heap.poll();
            res[i] = newRes;
        }
        return res;
    }
}
