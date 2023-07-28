class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[n+1];
        int[] sum = new int[n+1];
        cnt[0] = 1;
        int s = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i] == 1 ? 1 : -1;
            sum[i+1] = s;
            if (s >= k) {
                res += cnt[s-k];
            }
            cnt[s]++;
        }
        return res;
    }
}