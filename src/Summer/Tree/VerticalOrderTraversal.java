package Summer.Tree;

import Summer.TreeNode;

import java.util.*;

public class VerticalOrderTraversal
{
    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        TreeMap<Integer, List<Pair>> map =new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,root));
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        while (!queue.isEmpty())
        {
            Pair pair = queue.poll();
            minX = Math.min(minX,pair.x);
            maxX = Math.max(maxX, pair.x);
            if (pair.node.left!=null)
            {
                queue.offer(new Pair(pair.x-1, pair.y+1, pair.node.left ));
            }
            if (pair.node.right!=null)
            {
                queue.offer(new Pair(pair.x+1, pair.y+1, pair.node.right ));
            }
            if (!map.containsKey(pair.x))
            {
                map.put(pair.x, new ArrayList<>());
            }
            map.get(pair.x).add(pair);
        }

        for (int i=minX;i<=maxX;i++)
        {
            Collections.sort(map.get(i), new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.y==o2.y)
                    {
                        return o1.node.val- o2.node.val;
                    }
                    return 0;
                }
            });
            List<Integer> tempList = new ArrayList<>();
            for (int j=0;j<map.get(i).size();j++)
            {
                tempList.add(map.get(i).get(j).node.val);
            }
            res.add(tempList);
        }
        return res;

    }

    private class Pair
    {
        int x;
        int y;
        TreeNode node;

        public Pair(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
}
