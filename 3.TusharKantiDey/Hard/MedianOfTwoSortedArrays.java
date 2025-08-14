// MedianOfTwoSortedArrays.java
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    // Local testing
    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();

        int[][] a1 = {{1, 3}, {1, 2}, {}};
        int[][] a2 = {{2}, {1, 3, 4}, {2, 3}};

        for (int i = 0; i < a1.length; i++) {
            double median = sol.findMedianSortedArrays(a1[i], a2[i]);
            System.out.printf("nums1=%s, nums2=%s → median=%.5f%n",
                java.util.Arrays.toString(a1[i]), java.util.Arrays.toString(a2[i]), median);
        }
    }
}
