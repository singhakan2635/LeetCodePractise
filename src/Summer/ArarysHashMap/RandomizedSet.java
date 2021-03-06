package Summer.ArarysHashMap;

import java.util.*;

public class RandomizedSet
{
    Map<Integer,Integer> map ;
    ArrayList<Integer> list;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val))
        {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val))
        {
            int loc = map.get(val);
            if (loc<list.size()-1)
            {
                int lastVal= list.get(list.size()-1);
                list.set(loc,lastVal);
                map.put(lastVal,loc);
            }
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom()
    {
        return list.get(random.nextInt(list.size()));
    }
}
