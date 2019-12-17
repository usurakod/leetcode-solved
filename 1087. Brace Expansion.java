/*
A string S represents a list of words.

Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is. 
If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.

 

Example 1:

Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:

Input: "abcd"
Output: ["abcd"]
****************************************************************************************************************************************/

class Solution {
    List<String> ans;
    public String[] expand(String S) {
        List<boolean[]> grouping = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            grouping.add(new boolean[26]);
            if(S.charAt(i) == '{'){
                i++;
                
                while(S.charAt(i) != '}'){
                    if(S.charAt(i) != ','){
                        grouping.get(grouping.size()-1)[S.charAt(i)-'a'] = true;
                    }  
                  i++;
                }
            }
            else{
                grouping.get(grouping.size()-1)[S.charAt(i)-'a'] = true;
            }
        }
        
        ans = new ArrayList<>();
        dfs(grouping, new StringBuilder());
        return ans.toArray(new String[ans.size()]);
    }
    
    
    public void dfs(List<boolean[]> grouping, StringBuilder sb){
        if(sb.length() >= grouping.size()){
            ans.add(sb.toString());
            return;
        }
        boolean[] list = grouping.get(sb.length());
        for(int i=0;i<26;i++){
            if(!list[i]) continue;
            sb.append((char)(i + 'a'));
            dfs(grouping,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
