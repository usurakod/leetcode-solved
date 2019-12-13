/*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

************************************************************************************************************************************************************************************************/

class Solution {
    public String decodeString(String s) {
        if(s == null){
             return "";          
        }
        Stack<String> sta = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n=0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                int n1 = Character.getNumericValue(c);
                n = n*10+n1;
            }
            else if(c == '['){
                sta.add(sb.toString());
                num.add(n);
                n=0;
                sb = new StringBuilder();
            }
            else if(c == ']'){
                String val = sb.toString();
                int times = num.pop();
                while(--times != 0){
                    sb.append(val);
                }
                sb.insert(0,sta.pop());
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
