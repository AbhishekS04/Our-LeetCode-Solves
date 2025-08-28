
//! Given an integer x, return true if x is a palindrome, and false otherwise.

 

//! Example 1:

//! Input: x = 121
//! Output: true
//! Explanation: 121 reads as 121 from left to right and from right to left.
//! Example 2:

//! Input: x = -121
//! Output: false
//! Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//! Example 3:

//! Input: x = 10
//! Output: false
//! Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

//! Constraints:

//! -231 <= x <= 231 - 1
 

//! Follow up: Could you solve it without converting the integer to a string?

// LeetCode-style solution class (filename matches: palindrome.java)
// Uses half-reversal technique to avoid overflow and disallows string conversion.
// Time: O(log10 n)  Space: O(1)
class palindrome {
	public boolean isPalindrome(int x) {
		// Negatives are not palindrome; numbers ending in 0 (but not 0 itself) aren't either.
		if (x < 0 || (x % 10 == 0 && x != 0)) return false;

		int revHalf = 0; // reversed second half of digits
		// Build reversed half until it becomes >= remaining first half
		while (x > revHalf) {
			revHalf = revHalf * 10 + x % 10;
			x /= 10;
		}
		// For even length: x == revHalf
		// For odd length: drop middle digit of revHalf via /10
		return x == revHalf || x == revHalf / 10;
	}

	// Local test harness
	public static void main(String[] args) {
		palindrome sol = new palindrome();
		int[] samples;
		if (args.length > 0) {
			samples = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				try { samples[i] = Integer.parseInt(args[i]); }
				catch (NumberFormatException e) { System.out.println(args[i] + " -> invalid int"); }
			}
		} else {
			samples = new int[]{121, -121, 10, 0, 12321, 1221, 2147447412};
		}
		for (int v : samples) {
			System.out.println(v + " -> " + sol.isPalindrome(v));
		}
	}
}




