class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int mod = 1000000007;
        int sum = 0;
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            if (max < diff) {
                max = diff;
                maxIdx = i;
            }
        }
        int minDiff = max;
        for (int i = 0; i < n; i++) {
            minDiff = Math.min(minDiff, Math.abs(nums1[i] - nums2[maxIdx]));
        }
        return (sum - max + minDiff) % mod;
    }
}