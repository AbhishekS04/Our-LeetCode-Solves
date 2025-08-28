//! https://leetcode.com/problems/4sum/description

/**
 * @class Solution
 * @brief Provides a solution to the 4Sum problem.
 * 
 * This class contains a method to find all unique quadruplets in a given array
 * that sum up to a specified target value.
 */

/**
 * @function fourSum
 * @brief Finds all unique quadruplets in the array that sum up to the target.
 * 
 * @param nums A vector of integers representing the input array.
 * @param target A long long integer representing the target sum.
 * @return A vector of vectors, where each inner vector contains four integers
 *         that sum up to the target.
 * 
 * The function sorts the input array and uses a nested loop with two pointers
 * to efficiently find all unique quadruplets that satisfy the condition. It
 * skips duplicate elements to ensure that the result contains only unique
 * quadruplets.
 * 
 * @note The function assumes that the input array may contain duplicates and
 *       handles them appropriately.
 * 
 * @complexity
 * Time Complexity: O(n^3), where n is the size of the input array. This is due
 *                  to the three nested loops and the two-pointer approach.
 * Space Complexity: O(1) additional space, excluding the space required for
 *                   the output vector.
 */
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, long long target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        int n = nums.size();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue; // skip duplicates

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long long sum = (long long)nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        res.push_back({nums[i], nums[j], nums[left], nums[right]});
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
};
