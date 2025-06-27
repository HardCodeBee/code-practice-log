public class Q5_Longest_Palindromic_Substring {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     */



    public String longestPalindrome_1(String s) {
        /**Brute Force + Set Approach*
         *  Time Complexity: O(n²)
         *  Space Complexity: O(k)
         */
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * helper which can make sure all substring is valid palindromic
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public String longestPalindrome_2(String s) {
        /**
         * Dynamic Programming
         * For substrings of length 1:
         * They are trivially palindromes.
         *
         * For substrings of length 2:
         * They are palindromes if and only if the two characters are equal.
         *
         * For substrings of length >2:
         * P(i, j) = P(i + 1, j - 1) && (s[i] == s[j])
         */

        int ans1 = 0, ans2 = 0;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j] = true;
                } else if (j + 1 == i) {
                    dp[j] = s.charAt(j) == s.charAt(i);
                } else {
                    // dp[j] only depends on dp[j + 1] from the previous round of the outer loop
                    // (when the right boundary was at i - 1).
                    dp[j] = s.charAt(j) == s.charAt(i) ? dp[j + 1] : false;
                }
                if (dp[j] && i - j > ans2 - ans1) {
                    //update result if substring is valid and longer
                    ans2 = i;
                    ans1 = j;
                }
            }
        }
        return s.substring(ans1, ans2 + 1);
    }
}
