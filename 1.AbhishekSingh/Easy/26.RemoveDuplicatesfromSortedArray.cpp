//! 26. Remove Duplicates from Sorted Array

/*
This solution removes duplicates from a sorted array in-place and returns the number of unique elements.

How it works:
1. We use two pointers: i (slow) and j (fast)
2. i keeps track of the last unique element position
3. j scans through the array looking for new unique elements
4. When a new unique element is found (nums[j] != nums[i]):
   - We increment i to the next position
   - Copy the new unique element to position i
5. At the end, i+1 gives us the count of unique elements

Time Complexity: O(n) where n is array length
Space Complexity: O(1) as we modify array in-place

Example:
nums = [1,1,2,2,3]
- Initially: i=0, j=1
- When j=2: nums[2]=2 != nums[0]=1, so i=1, nums[1]=2
- When j=4: nums[4]=3 != nums[1]=2, so i=2, nums[2]=3
- Result: [1,2,3,2,3], return 3
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // Handle empty array case
        if (nums.empty()) return 0;
        
        int n = nums.size();
        int i = 0;  // slow pointer - tracks last unique element position
        
        // j is fast pointer - scans for new unique elements
        for(int j = 1; j < n; j++) {
            // When we find a new unique element
            if(nums[j] != nums[i]) {
                i++;  // move slow pointer
                nums[i] = nums[j];  // place new unique element
            }
        }
        
        return i + 1;  // length of unique elements (i + 1 because i is 0-based)
    }
};
