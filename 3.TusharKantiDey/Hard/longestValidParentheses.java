//! Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 

//! Example 1:

//! Input: s = "(()"
//! Output: 2
//! Explanation: The longest valid parentheses substring is "()".
//! Example 2:

//! Input: s = ")()())"
//! Output: 4
//! Explanation: The longest valid parentheses substring is "()()".
//! Example 3:

//! Input: s = ""
//! Output: 0
 

//! Constraints:

//! 0 <= s.length <= 3 * 104
//! s[i] is '(', or ')'.






import java.util.ArrayDeque;
import java.util.Deque;

class longestValidParentheses {
    /**
     * Calculates the length of the longest valid (well-formed) parentheses substring.
     *
     * This method uses a stack to keep track of the indices of the characters. The
     * core idea is that the length of any valid substring can be determined by the
     * difference between the current index and the index of the last unmatched
     * parenthesis.
     *
     * @param s The input string containing just '(' and ')'.
     * @return The length of the longest valid parentheses substring.
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        // Use a Deque as a stack, which is the recommended modern approach in Java.
        // The stack will store indices.
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Push -1 onto the stack to act as a sentinel value. This simplifies the
        // logic by providing a base for the very first valid substring. For
        // example, for "()", when we are at index 1, the length is 1 - (-1) = 2.
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                // If it's an opening parenthesis, push its index onto the stack.
                stack.push(i);
            } else { // currentChar == ')'
                // If it's a closing parenthesis, we pop from the stack.
                stack.pop();

                if (stack.isEmpty()) {
                    // If the stack becomes empty, it means the current ')' is not matched.
                    // We push the current index 'i' to serve as the new "base" or
                    // boundary for the next potential valid substring.
                    stack.push(i);
                } else {
                    // If the stack is not empty, a pair has been successfully matched.
                    // The length of the current valid substring is the difference between
                    // the current index and the index at the top of the stack.
                    // The element at stack.peek() is the index of the character
                    // just before the start of this valid substring.
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    // Example Usage:
    public static void main(String[] args) {
        longestValidParentheses solver = new longestValidParentheses();

        // Example 1
        String s1 = "(()";
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: " + solver.longestValidParentheses(s1)); // Expected: 2

        System.out.println("--------------------");

        // Example 2
        String s2 = ")()())";
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: " + solver.longestValidParentheses(s2)); // Expected: 4
        
        System.out.println("--------------------");

        // Example 3
        String s3 = "";
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Output: " + solver.longestValidParentheses(s3)); // Expected: 0
    }
}

