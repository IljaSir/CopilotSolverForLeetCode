class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        long ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums1[i] - diff;
            int l = 0;
            int r = i - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums2[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            dp[i] = l;
        }
        for (int i = 0; i < n; i++) {
            int num = nums1[i] - nums2[i];
            int l = i + 1;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums1[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans += l - dp[i];
        }
        return ans;
    }
}