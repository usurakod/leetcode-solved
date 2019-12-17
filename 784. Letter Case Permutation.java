/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. 
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
****************************************************************************************************************************************************************************/

class Solution {
    List<String> ans = new ArrayList<>();
    char[] chars = null; 
    public List<String> letterCasePermutation(String S) {
        chars = S.toLowerCase().toCharArray();
        backtrack(0);
        return ans;
    }
    
    public void backtrack(int index){
        if(index == chars.length){
            ans.add(new String(chars));
            return;
        }
        
        backtrack(index+1); // for lower case
        char lower = chars[index];
        if(!Character.isDigit(lower)){
            chars[index] = (char)(lower - 32);//for upper case
            backtrack(index+1);
            chars[index] = lower;
        }
    }
}
