class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] cnt = new int[n+1];
        for (int i = 0; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                cnt[nums1[i]]++;
            } else {
                cnt[nums1[i]]++;
                cnt[nums2[i]]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ans += 2;
            } else if (cnt[i] == 1) {
                ans += 1;
            }
        }
        return ans;
    }
}