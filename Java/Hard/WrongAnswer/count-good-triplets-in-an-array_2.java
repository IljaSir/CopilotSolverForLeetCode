class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums2[j] <= nums2[i]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums2[k] <= nums2[j] || nums1[k] <= nums1[j]) {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}