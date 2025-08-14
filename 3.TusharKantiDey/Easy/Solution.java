import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            numToIndex.put(nums[i], i);
        }

        return new int[0]; // No solution case
    }

    // Simple demo main so the class can be executed directly
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        if (args.length > 0) {
            // Allow optional overriding target via first argument
            try { target = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) { }
        }
        int[] result = new Solution().twoSum(nums, target);
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("No solution");
        }
    }
}
