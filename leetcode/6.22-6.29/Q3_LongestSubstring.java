import java.util.HashSet;
import java.util.Set;

public class Q3_LongestSubstring {
    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     *
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param s
     * @return the length of longest String without repeating
     */


    /**Brute Force + Set Approach*
     *  Time Complexity: O(n²)
     *  Space Complexity: O(k)
     */

    public int lengthOfLongestSubstring(String s) {
        if(s.length() ==0 || s == null){
            return 0;
        }
        int result = 0;
        StringBuffer checkCharList = new StringBuffer(s);
        for(int a =0;a<s.length();a++){
            int currentlength = 0;
            Set<Character> checkSet = new HashSet<>();     // use Set to make sure no duplicating elements
            for(int b=a;b<s.length();b++){
                Character currentChar = checkCharList.charAt(b);
                if(!checkSet.contains(currentChar)){
                    checkSet.add(currentChar);              // if it does not contain, then append
                    currentlength++;
                    System.out.println(checkSet);
                }else {                                     // if contained, then break
                    break;
                }
                if(currentlength>result){                   // update the result
                    result = currentlength;
                }
            }
        }

        return result;
    }

    /**Sliding Window Approach
     * //The outer loop expands the right boundary, and the inner loop expands the left boundary.
     * for (int l = 0, r = 0 ; r < n ; r++) {
     * 	//consider current element
     * 	while (l <= r && check()) {//interval [left,right] does not true
     *         //expand left boundary
     *     }
     * }
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //liding Window
            char[] ss = s.toCharArray();
            Set<Character> set = new HashSet<>();//remove duplicated elements
            int res = 0;//result
            for(int left = 0, right = 0; right < s.length(); right++) {     //extend right boundary
                char ch = ss[right];                                        //right points to the element currently under consideration
                while(set.contains(ch)) {                                   //set contains 'ch'，shorten the left boundary
                    set.remove(ss[left]);
                    left++;
                }
                set.add(ss[right]);//append the current element
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

}
