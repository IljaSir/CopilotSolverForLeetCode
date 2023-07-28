class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int r = nums[i] % k;
            if (r < 0) {
                r += k;
            }
            ans += cnt[(k - r) % k];
            cnt[r]++;
        }
        return ans;
    }
}