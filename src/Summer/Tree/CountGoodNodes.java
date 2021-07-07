package Summer.Tree;

import Summer.TreeNode;

public class CountGoodNodes
{
    int count=0;
    public int goodNodes(TreeNode root)
    {
        if (root==null)
            return count;
        dfs(root, root.val);
        return count;

    }
    private void dfs(TreeNode root,int maxval)
    {
        if (root==null)
            return;
        if (root.val>= maxval)
            count++;
        int max = Math.max(maxval,root.val);
        dfs(root.left,max);
        dfs(root.right,max);
    }
}
