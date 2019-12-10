Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

******************************************************************************************************************************************************************************************************************

class LRUCache {
    private int cap;
    Map<Integer,Integer> map;
    Deque<Integer> dq;
    
    
    public LRUCache(int capacity) {
        cap = capacity;
        dq = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            dq.remove(key);
            dq.addLast(key);
            
            return map.get(key);
        }
        
        return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            dq.remove(key);
            dq.addLast(key);  
            map.put(key,value);
            return;
        }
        if(dq.size() == cap){
           Integer front = dq.remove();
            map.remove(front);
            dq.addLast(key);
        }
        else{
            dq.addLast(key);
        }
          map.put(key,value);
    }
   
}
