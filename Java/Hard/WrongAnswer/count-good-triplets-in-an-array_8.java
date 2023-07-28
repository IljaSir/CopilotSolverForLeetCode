class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums1[i] <= nums1[j]) {
                    for (int k = j + 1; k < n; ++k) {
                        if (nums1[j] <= nums1[k] && nums2[i] <= nums2[j] && nums2[j] <= nums2[k]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}