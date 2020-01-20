/* Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

***********************************************************************************************************************/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
       List<Integer> list = new ArrayList<>();
        
       for(int i=0;i<nums.length;i++){
           if(map.containsKey(nums[i])){
               map.put(nums[i], map.get(nums[i])+1);
           }
           else
           {
               map.put(nums[i],1);
           }
       }
        
        //sort the values in the ascending order of the count
        PriorityQueue<Integer> heap = new PriorityQueue<Integer> (
        (n1,n2) -> map.get(n1) - map.get(n2));
        
        for(int key: map.keySet()){
            heap.add(key);
            
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        while(heap.size() != 0) 
        {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
