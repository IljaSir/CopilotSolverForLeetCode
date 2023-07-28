class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        long ans = 0;
        int[] cnt = new int[20001];
        for (int i = 0; i < n; ++i) {
            int x = nums1[i] - nums2[i] + 10000;
            ans += cnt[x - diff];
            cnt[x]++;
        }
        return ans;
    }
}