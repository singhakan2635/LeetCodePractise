package Summer.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap
{
    /** Initialize your data structure here. */

    Map<String, TreeMap<Integer,String>> map ;
    public TimeMap()
    {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp)
    {
        if (!map.containsKey(key))
        {
            map.put(key,new TreeMap<>());
        }
        TreeMap<Integer,String> tree = map.get(key);
        tree.put(timestamp,value);
        map.put(key, tree);

    }

    public String get(String key, int timestamp)
    {
        TreeMap<Integer,String> treeMap = map.get(key);
        if (treeMap==null)
            return "";
        Integer floorKey = treeMap.floorKey(timestamp);
        if (floorKey==null)
            return "";
        return treeMap.get(floorKey);
    }
}
