package Summer.Design;

import java.util.*;

public class FileSystem
{
    Map<String, Set<String>> map;
    Map<String,String> doc;
    String pointer ="";

    public FileSystem() {
        map = new HashMap<>();
        List<String> ls;

        map.put("/",new HashSet<>());
        doc = new HashMap<>();
    }

    public List<String> ls(String path)
    {
        if(path=="/")
        {
            return convertSetTolIst(map.get(path));
        }
        else
        {
            String[] paths = path.split("/");
            return convertSetTolIst(map.get(paths[paths.length-1]));
        }
    }

    private List<String> convertSetTolIst(Set<String> set)
    {
        List<String> list = new ArrayList<>();
        for (String s: set)
        {
            list.add(s);
        }
        Collections.sort(list);
        return list;
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        for (int i=0;i<paths.length;i++)
        {
            Set<String> set = map.get("/");
            if (i==0 && set.isEmpty())
            {
                set.add(paths[i]);
                map.put("/",set);
                Set<String> values = new HashSet<>();
                values.add(paths[i+1]);
                map.put(paths[i],values);
            }
            else if (i== paths.length-1 && !map.containsKey(paths[paths.length-1]))
            {
                map.put(paths[paths.length-1],new HashSet<>());
            }
            else
            {
                if (!map.containsKey(paths[i]))
                {
                    map.put(paths[i],new HashSet<>());
                }
                Set<String> values = map.get(paths[i]);
                if (!values.contains(paths[i+1]))
                {
                    values.add(paths[i+1]);
                    map.put(paths[i],values);
                }
            }
        }
    }

    public void addContentToFile(String filePath, String content)
    {
        String[] paths = filePath.split("/");
        if (map.containsKey(paths[paths.length-2])) {
            Set<String> set = map.get(paths[paths.length - 2]);
            set.add(paths[paths.length - 1]);
            map.put(paths[paths.length - 2], set);
            if (!doc.containsKey(filePath)) {
                doc.put(filePath, content);
            } else {
                String str = doc.get(filePath);
                doc.put(filePath, str + content);
            }
        }
    }

    public String readContentFromFile(String filePath)
    {

        return doc.get(filePath);

    }
}