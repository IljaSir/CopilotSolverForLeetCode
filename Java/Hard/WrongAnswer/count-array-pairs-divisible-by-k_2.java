class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        long[] cnt = new long[k];
        for (int i = 0; i < n; i++) {
            cnt[nums[i] % k]++;
        }
        long ans = 0;
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0 || i == k - i) {
                ans += cnt[i] * (cnt[i] - 1) / 2;
            } else {
                ans += cnt[i] * cnt[k - i];
            }
        }
        return ans;
    }
}