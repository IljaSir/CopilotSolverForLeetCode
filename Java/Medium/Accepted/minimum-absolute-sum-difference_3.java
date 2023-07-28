class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);
        int maxDiff = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % 1000000007;
            int j = Arrays.binarySearch(sortedNums1, nums2[i]);
            if (j < 0) {
                j = -j - 1;
            }
            if (j < n) {
                maxDiff = Math.max(maxDiff, diff - (sortedNums1[j] - nums2[i]));
            }
            if (j > 0) {
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - sortedNums1[j - 1]));
            }
        }
        return (sum - maxDiff + 1000000007) % 1000000007;
    }
}