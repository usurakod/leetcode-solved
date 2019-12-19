/*For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
******************************************************************************************************************************************************/
class Solution {
    public static String gcdOfStrings(String str1, String str2) {
    	if (str1.length()<str2.length())
    		return gcdOfStrings(str2, str1);
    	
    	if (str2.length()==0)
    		return str1;
    	
    	if (str1.startsWith(str2)) {
    		str1 = str1.substring(str2.length());
            System.out.println("str1: "+str1+ " str2: "+str2);
            
    		return gcdOfStrings(str1, str2);
    	}else
    		return "";
    }
}
