//! Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

//! The algorithm for myAtoi(string s) is as follows:

//! Whitespace: Ignore any leading whitespace (" ").
//! Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//! Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//! Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//! Return the integer as the final result.

 

//! Example 1:

//! Input: s = "42"

//! Output: 42

//! Explanation:

//! The underlined characters are what is read in and the caret is the current reader position.
//! Step 1: "42" (no characters read because there is no leading whitespace)
//!          ^
//! Step 2: "42" (no characters read because there is neither a '-' nor '+')
//!          ^
//! Step 3: "42" ("42" is read in)
//!            ^
//! Example 2:

//! Input: s = " -042"

//! Output: -42

//! Explanation:

//! Step 1: "   -042" (leading whitespace is read and ignored)
//!             ^
//! Step 2: "   -042" ('-' is read, so the result should be negative)
//!              ^
//! Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//!                ^
//! Example 3:

//! Input: s = "1337c0d3"

//! Output: 1337

//! Explanation:

//! Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//!         ^
//! Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//!          ^
//! Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//!              ^
//! Example 4:

//! Input: s = "0-1"

//! Output: 0

//! Explanation:

//! Step 1: "0-1" (no characters read because there is no leading whitespace)
//!          ^
//! Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//!          ^
//! Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//!           ^
//! Example 5:

//! Input: s = "words and 987"

//! Output: 0

//! Explanation:

//! Reading stops at the first non-digit character 'w'.

 

//! Constraints:

//! 0 <= s.length <= 200
//! s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

// Implementation of myAtoi according to the above specification.
// File name kept lowercase; class is package-private (no public modifier) so it compiles as-is.
class stringtointeger {
	private static final int INT_MAX = 2147483647; //  2^31 - 1
	private static final int INT_MIN = -2147483648; // -2^31

	public int myAtoi(String s) {
		if (s == null || s.isEmpty()) return 0;
		int i = 0, n = s.length();

		// 1. Skip leading whitespace
		while (i < n && s.charAt(i) == ' ') i++;
		if (i == n) return 0;

		// 2. Sign
		int sign = 1;
		char c = s.charAt(i);
		if (c == '+' || c == '-') {
			if (c == '-') sign = -1;
			i++;
		}

		// 3. Parse digits
		long acc = 0; // use long internally just to detect overflow before casting
		while (i < n) {
			char ch = s.charAt(i);
			if (ch < '0' || ch > '9') break;
			int digit = ch - '0';

			// Check overflow before adding digit (without using 64-bit finalize; we rely on bounds)
			if (acc > INT_MAX / 10 || (acc == (INT_MAX / 10) && digit > 7)) {
				return sign == 1 ? INT_MAX : INT_MIN;
			}
			acc = acc * 10 + digit;
			i++;
		}

		acc *= sign;
		// Clamp (should already be clamped in overflow check, but keep safety)
		if (acc > INT_MAX) return INT_MAX;
		if (acc < INT_MIN) return INT_MIN;
		return (int) acc;
	}

	// Simple local test harness
	public static void main(String[] args) {
		stringtointeger solver = new stringtointeger();
		if (args.length > 0) {
			for (String in : args) {
				System.out.println("'" + in + "' -> " + solver.myAtoi(in));
			}
			return;
		}
		String[] samples = {
				"42",
				"   -042",
				"1337c0d3",
				"0-1",
				"words and 987",
				"9223372036854775808", // overflow -> INT_MAX
				"-91283472332", // underflow -> INT_MIN
				"+1",
				"   +0 123",
				"  0000000000012345678"
		};
		for (String s : samples) {
			System.out.println("'" + s + "' -> " + solver.myAtoi(s));
		}
	}
}