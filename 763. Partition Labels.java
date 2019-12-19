/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

*********************************************************************************************************************************************************************************/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for(int i=0;i<S.length();i++){
           last[S.charAt(i) - 'a'] = i;
        }
        
        int start=0, j=0;
        for(int i=0;i<S.length();i++){
             j = Math.max(j,last[S.charAt(i)- 'a']);
            if( i == j){
                res.add(j-start+1);
                start = j+1;
            }
        }
        return res;
    }
}
