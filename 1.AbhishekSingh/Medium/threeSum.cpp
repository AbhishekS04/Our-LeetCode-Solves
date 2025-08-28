// ! https://leetcode.com/problems/3sum/description

/**
 * @class Solution
 * @brief Provides a solution to the "3Sum" problem, which finds all unique triplets in an array that sum up to zero.
 * 
 * @method threeSum
 * @param nums A reference to a vector of integers, which may contain positive, negative, and zero values.
 * @return A vector of vectors, where each inner vector represents a unique triplet of integers from the input array that sum to zero.
 * 
 * @details
 * The method follows these steps:
 * 1. Sorts the input array to facilitate the use of the two-pointer technique.
 * 2. Iterates through the array, treating each element as a potential first element of a triplet.
 * 3. Uses two pointers (`left` and `right`) to find pairs of numbers that, along with the current element, sum to zero.
 * 4. Skips duplicate elements to ensure that only unique triplets are included in the result.
 * 
 * @note
 * - The input array is modified (sorted) during the execution of this method.
 * - The algorithm has a time complexity of O(n^2), where n is the size of the input array.
 * - The result does not include duplicate triplets.
 * 
 * Example:
 * Input: nums = {-1, 0, 1, 2, -1, -4}
 * Output: {{-1, -1, 2}, {-1, 0, 1}}
 */
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        int n = nums.size();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.push_back({nums[i], nums[left], nums[right]});
                    // skip duplicates
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        return res;
    }
};

