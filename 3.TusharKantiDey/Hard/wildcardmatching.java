//! Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

//! '?' Matches any single character.
//! '*' Matches any sequence of characters (including the empty sequence).
//! The matching should cover the entire input string (not partial).

 

//! Example 1:

//! Input: s = "aa", p = "a"
//! Output: false
//! Explanation: "a" does not match the entire string "aa".
//! Example 2:

//! Input: s = "aa", p = "*"
//! Output: true
//! Explanation: '*' matches any sequence.
//! Example 3:

//! Input: s = "cb", p = "?a"
//! Output: false
//! Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

//! Constraints:

//! 0 <= s.length, p.length <= 2000
//! s contains only lowercase English letters.
//! p contains only lowercase English letters, '?' or '*'.




class wildcardmatching{
    /**
     * Implements wildcard pattern matching with support for '?' and '*'.
     *
     * @param s The input string (contains only lowercase English letters).
     * @param p The pattern (contains lowercase letters, '?', or '*').
     * @return true if the pattern matches the entire input string, false otherwise.
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // dp[i][j] will be true if the first i characters of s
        // match the first j characters of p
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        // Base Case 1: Empty pattern and empty string match
        dp[0][0] = true;

        // Base Case 2: Empty string and pattern with '*'
        // A non-empty pattern can match an empty string only if it's all '*'
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '*') {
                    // Two cases for '*':
                    // 1. '*' matches an empty sequence (we look at dp[i][j-1]).
                    // 2. '*' matches the current character sChar (we look at dp[i-1][j]).
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pChar == '?' || sChar == pChar) {
                    // '?' matches any single character, or characters match directly.
                    // The result depends on the match of the previous substrings.
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If none of the above, dp[i][j] remains false by default.
            }
        }

        return dp[sLen][pLen];
    }

    // Example Usage:
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1
        String s1 = "aa", p1 = "a";
        System.out.println("s = \"" + s1 + "\", p = \"" + p1 + "\" -> " + solver.isMatch(s1, p1)); // false

        // Example 2
        String s2 = "aa", p2 = "*";
        System.out.println("s = \"" + s2 + "\", p = \"" + p2 + "\" -> " + solver.isMatch(s2, p2)); // true

        // Example 3
        String s3 = "cb", p3 = "?a";
        System.out.println("s = \"" + s3 + "\", p = \"" + p3 + "\" -> " + solver.isMatch(s3, p3)); // false
        
        // Example 4
        String s4 = "adceb", p4 = "*a*b";
        System.out.println("s = \"" + s4 + "\", p = \"" + p4 + "\" -> " + solver.isMatch(s4, p4)); // true
        
        // Example 5
        String s5 = "acdcb", p5 = "a*c?b";
        System.out.println("s = \"" + s5 + "\", p = \"" + p5 + "\" -> " + solver.isMatch(s5, p5)); // false
    }
}

