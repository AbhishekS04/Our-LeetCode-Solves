//! Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

//! '.' Matches any single character.​​​​
//!'*' Matches zero or more of the preceding element.
//! The matching should cover the entire input string (not partial).

 

//! Example 1:

//! Input: s = "aa", p = "a"
//! Output: false
//! Explanation: "a" does not match the entire string "aa".
//! Example 2:

//! Input: s = "aa", p = "a*"
//! Output: true
//! Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//! Example 3:

//! Input: s = "ab", p = ".*"
//! Output: true
//! Explanation: ".*" means "zero or more (*) of any character (.)".
 

//! Constraints:

//! 1 <= s.length <= 20
//! 1 <= p.length <= 20
//! s contains only lowercase English letters.
//! p contains only lowercase English letters, '.', and '*'.
//! It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

// Implementation using bottom-up DP.
// dp[i][j] = whether first i chars of s match first j chars of p.
// Time: O(m*n)  Space: O(m*n) (m = s.length, n = p.length) — can be optimized to O(n).
class regular_expression_matching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		// Patterns like a*, a*b*, a*b*c* can match empty string
		for (int j = 2; j <= n; j++) {
			if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char pc = p.charAt(j - 1);
				if (pc == '*') {
					// Zero of previous element
					dp[i][j] = dp[i][j - 2];
					char prev = p.charAt(j - 2);
					if (prev == '.' || prev == s.charAt(i - 1)) {
						// One more of previous element
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				} else if (pc == '.' || pc == s.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}
		return dp[m][n];
	}

	// Alternative recursive + memo (not used in main logic)
	public boolean isMatchRecursive(String s, String p) {
		return matchMemo(s, p, 0, 0, new Boolean[s.length()+1][p.length()+1]);
	}
	private boolean matchMemo(String s, String p, int i, int j, Boolean[][] memo) {
		if (memo[i][j] != null) return memo[i][j];
		boolean ans;
		if (j == p.length()) ans = (i == s.length());
		else {
			boolean first = (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)));
			if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
				ans = matchMemo(s, p, i, j + 2, memo) || (first && matchMemo(s, p, i + 1, j, memo));
			} else {
				ans = first && matchMemo(s, p, i + 1, j + 1, memo);
			}
		}
		return memo[i][j] = ans;
	}

	// Local test harness
	public static void main(String[] args) {
		regular_expression_matching sol = new regular_expression_matching();
		if (args.length == 2) {
			System.out.println(sol.isMatch(args[0], args[1]));
			return;
		}
		String[][] tests = {
			{"aa", "a", "false"},
			{"aa", "a*", "true"},
			{"ab", ".*", "true"},
			{"aab", "c*a*b", "true"},
			{"mississippi", "mis*is*p*.", "false"},
			{"", "", "true"},
			{"", "a*", "true"},
			{"ab", ".*c", "false"},
		};
		for (String[] t : tests) {
			boolean got = sol.isMatch(t[0], t[1]);
			System.out.println("s=\"" + t[0] + "\" p=\"" + t[1] + "\" -> " + got + " (exp " + t[2] + ")");
		}
	}
}