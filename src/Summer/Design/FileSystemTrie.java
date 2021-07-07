package Summer.Design;

import java.util.*;

public class FileSystemTrie
{
    private class FileNode
    {
        public Map<String, FileNode> children;
        public boolean isFile;
        public String fileContent;

        public FileNode( boolean isFile) {
            this.children = new HashMap<>();
            this.isFile = isFile;
            this.fileContent = "";
        }
    }

    FileNode root;
    public FileSystemTrie()
    {
        root= new FileNode(false);

    }

    public List<String> ls(String path)
    {
        String[] paths = path.split("/");
        FileNode fileNode = root;
        List<String> res = new ArrayList<>();
        for (int i=1;i< paths.length;i++)
        {
            fileNode = fileNode.children.get(paths[i]);
        }

        if (fileNode.isFile)
        {
            res.add(paths[paths.length-1]);
            return res;
        }

        for (String str: fileNode.children.keySet())
        {
            res.add(str);
        }
        Collections.sort(res);
        return res;

    }

    public void mkdir(String path)
    {
        String[] paths = path.split("/");
        FileNode fileNode = root;
        for (int i=1;i<paths.length;i++)
        {
            if (fileNode.children.containsKey(paths[i]))
            {
                fileNode = fileNode.children.get(paths[i]);
                continue;
            }

            FileNode newNode = new FileNode(false);
            fileNode.children.put(paths[i],newNode);
            fileNode = newNode;
        }

    }

    public void addContentToFile(String filePath, String content)
    {
        String[] paths = filePath.split("/");
        FileNode fileNode = root;
        for (int i=1;i<paths.length;i++)
        {
            if (fileNode.children.containsKey(paths[i]))
            {
                fileNode = fileNode.children.get(paths[i]);
                continue;
            }

            FileNode newNode = new FileNode(i== paths.length-1);
            fileNode.children.put(paths[i],newNode);
            fileNode = newNode;
        }
        fileNode.fileContent += content;

    }

    public String readContentFromFile(String filePath)
    {
        String[] paths = filePath.split("/");
        FileNode node = root;
        for (int i=1;i< paths.length;i++)
        {
            if (node.children.containsKey(paths[i]))
            {
                node = node.children.get(paths[i]);
                continue;
            }
        }
        return node.fileContent;

    }
}
