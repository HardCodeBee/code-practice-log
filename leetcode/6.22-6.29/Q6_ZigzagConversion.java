import java.util.ArrayList;
import java.util.List;

public class Q6_ZigzagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * Example 3:
     *
     * Input: s = "A", numRows = 1
     * Output: "A"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consists of English letters (lower-case and upper-case), ',' and '.'.
     * 1 <= numRows <= 1000
     * @param s
     * @param numRows
     * @return
     */

        public String convert(String s, int numRows) {
            int n = s.length();
            int r = numRows;
            // 特殊情况：只有一行或行数大于等于字符总数时，直接返回原串
            if (r == 1 || r >= n) {
                return s;
            }
            // t 是一个完整周期的长度
            int t = r * 2 - 2;
            StringBuilder ans = new StringBuilder();

            // 枚举每一行
            for (int i = 0; i < r; i++) {
                // j 遍历所有周期的起始下标
                for (int j = 0; j + i < n; j += t) {
                    // 当前周期，位于第 i 行的字符
                    ans.append(s.charAt(j + i));
                    // 如果既不是第一行也不是最后一行，还要取当前周期的“斜列”字符
                    if (i > 0 && i < r - 1 && j + t - i < n) {
                        ans.append(s.charAt(j + t - i));
                    }
                }
            }
            return ans.toString();
        }
    }

