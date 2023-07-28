class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] nums1Sorted = nums1.clone();
        Arrays.sort(nums1Sorted);
        int maxDiff = 0;
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = Arrays.binarySearch(nums1Sorted, nums2[i]);
            if (j < 0) {
                j = -j - 1;
            }
            if (j < n) {
                maxDiff = Math.max(maxDiff, diff - (nums1Sorted[j] - nums2[i]));
            }
            if (j > 0) {
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - nums1Sorted[j - 1]));
            }
        }
        return (sum - maxDiff + mod) % mod;
    }
}