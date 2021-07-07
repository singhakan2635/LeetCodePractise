package Summer.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap1
{
    private class Pair
    {
        int time;
        String val;

        public Pair(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }

    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap1() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp)
    {
        if (!map.containsKey(key))
        {
            map.put(key, new ArrayList<Pair>());
        }
        List<Pair> list = map.get(key);
        list.add(new Pair(timestamp,value));
        map.put(key,list);

    }

    public String get(String key, int timestamp)
    {
        if (!map.containsKey(key))
            return "";
        return BinarySearch(key, timestamp, map.get(key));

    }

    private String BinarySearch(String key, int timestamp, List<Pair> list)
    {
        int left =0,right = list.size()-1;
        while (left<right)
        {
            int mid = (left+right) >>1;
            if (list.get(mid).time==timestamp)
                return list.get(mid).val;
            else if (list.get(mid).time<timestamp)
            {
                if (list.get(mid+1).time>timestamp)
                    return list.get(mid).val;
                else
                    left = mid+1;
            }
            else
            {
                right= mid-1;
            }
        }
        return list.get(left).time<=timestamp? list.get(left).val:"";
    }
}
