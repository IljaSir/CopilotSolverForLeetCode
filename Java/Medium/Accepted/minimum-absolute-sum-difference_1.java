class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] sortedNums1 = new int[n];
        System.arraycopy(nums1, 0, sortedNums1, 0, n);
        Arrays.sort(sortedNums1);
        int total = 0;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            total = (total + diff) % 1000000007;
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
        return (total - maxDiff + 1000000007) % 1000000007;
    }
}