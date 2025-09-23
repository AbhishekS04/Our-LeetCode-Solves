//! Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

//! Example 1:

//! Input: n = 3
//! Output: ["((()))","(()())","(())()","()(())","()()()"]
//! Example 2:

//! Input: n = 1
//! Output: ["()"]
 

//! Constraints:

//! 1 <= n <= 8








import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Generates all combinations of well-formed parentheses for n pairs.
     *
     * @param n The number of pairs of parentheses.
     * @return A list of strings containing all valid combinations.
     */
    public List<String> generateParenthesis(int n) {
        // This list will store the final combinations.
        List<String> result = new ArrayList<>();
        
        // Start the backtracking process with an empty string builder and zero counts.
        backtrack(result, new StringBuilder(), 0, 0, n);
        
        return result;
    }

    /**
     * A recursive helper function that builds the parenthesis strings using backtracking.
     *
     * @param result        The list to store the final results.
     * @param currentString The StringBuilder for the current combination being built.
     * @param openCount     The count of open parentheses '(' used so far.
     * @param closeCount    The count of closed parentheses ')' used so far.
     * @param maxPairs      The target number of pairs (n).
     */
    private void backtrack(List<String> result, StringBuilder currentString, int openCount, int closeCount, int maxPairs) {
        // Base case: If the string is complete, add its string representation to the result and return.
        if (currentString.length() == maxPairs * 2) {
            result.add(currentString.toString());
            return;
        }

        // --- Recursive Step ---

        // 1. Add an open parenthesis if we haven't reached the limit 'maxPairs'.
        if (openCount < maxPairs) {
            currentString.append("(");
            backtrack(result, currentString, openCount + 1, closeCount, maxPairs);
            // Backtrack: remove the character we just added to explore other possibilities.
            currentString.deleteCharAt(currentString.length() - 1);
        }

        // 2. Add a closed parenthesis if it doesn't violate the well-formed condition
        //    (i.e., the number of closed parentheses is less than the number of open ones).
        if (closeCount < openCount) {
            currentString.append(")");
            backtrack(result, currentString, openCount, closeCount + 1, maxPairs);
            // Backtrack: remove the character we just added.
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    // Example Usage:
    public static void main(String[] args) {
        GenerateParentheses solver = new GenerateParentheses();

        // Example 1
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        List<String> output1 = solver.generateParenthesis(n1);
        System.out.println("Output: " + output1);
        // Expected: ["((()))","(()())","(())()","()(())","()()()"]

        System.out.println("--------------------");

        // Example 2
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        List<String> output2 = solver.generateParenthesis(n2);
        System.out.println("Output: " + output2);
        // Expected: ["()"]
    }
}