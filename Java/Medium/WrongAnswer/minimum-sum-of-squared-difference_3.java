class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        long ans = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            ans += Math.pow(nums1[i] - nums2[i], 2);
        }
        int i = 0, j = nums1.length - 1;
        for (int k = 0; k < k1; k++) {
            if (i == nums1.length) break;
            if (nums1[i] < nums2[j]) {
                ans += Math.pow(nums2[j] - nums1[i], 2) - Math.pow(nums1[i] - nums2[i], 2);
                i++;
            } else {
                ans += Math.pow(nums1[i] - nums2[j], 2) - Math.pow(nums1[i] - nums2[i], 2);
                j--;
            }
        }
        return ans;
    }
}