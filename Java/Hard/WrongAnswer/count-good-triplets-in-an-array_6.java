class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums1[i] > nums1[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (nums2[i] < nums2[j] && nums2[j] < nums2[k] && nums1[j] < nums1[k]) ans++;
                }
            }
        }
        return ans;
    }
}