class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int sum = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] & 1;
            if (sum >= k) {
                res += cnt[sum - k];
            }
            cnt[sum]++;
        }
        return res;
    }
}