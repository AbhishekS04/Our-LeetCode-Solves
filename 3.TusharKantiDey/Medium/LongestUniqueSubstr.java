// LongestUniqueSubstr.java
import java.util.HashMap;

public class LongestUniqueSubstr {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                // Found a repeat within current window
                start = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    // Main for local testing
    public static void main(String[] args) {
        LongestUniqueSubstr sol = new LongestUniqueSubstr();
        String[] tests = {"abcabcbb", "bbbbb", "pwwkew", "", "au"};
        for (String t : tests) {
            System.out.printf("Input: \"%s\" → Output: %d%n",
                               t, sol.lengthOfLongestSubstring(t));
        }
    }
}
