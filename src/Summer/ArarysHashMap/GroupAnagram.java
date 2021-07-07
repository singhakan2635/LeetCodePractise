package Summer.ArarysHashMap;

import java.util.*;

public class GroupAnagram
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted))
            {
                map.put(sorted,new ArrayList<>());
            }
            List<String> list = map.get(sorted);
            list.add(str);
            map.put(sorted,list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> ls : map.values())
        {
            res.add(ls);
        }
        return res;

    }

}
