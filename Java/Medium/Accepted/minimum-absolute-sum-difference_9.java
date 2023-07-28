class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        long sum = 0;
        int mod = 1000000007;
        int maxDiff = 0;
        int maxDiffIndex = 0;
        int n = nums1.length;
        int[] copy = nums1.clone();
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            int j = binarySearch(copy, nums2[i]);
            if (j < n) {
                int newDiff = Math.abs(copy[j] - nums2[i]);
                if (newDiff < diff) {
                    if (diff - newDiff > maxDiff) {
                        maxDiff = diff - newDiff;
                        maxDiffIndex = i;
                    }
                }
            }
            if (j > 0) {
                j--;
                int newDiff = Math.abs(copy[j] - nums2[i]);
                if (newDiff < diff) {
                    if (diff - newDiff > maxDiff) {
                        maxDiff = diff - newDiff;
                        maxDiffIndex = i;
                    }
                }
            }
        }
        return (int)((sum - maxDiff) % mod);
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}