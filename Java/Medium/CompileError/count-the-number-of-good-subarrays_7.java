class Solution {
    public long countGood(int[] nums, int k) {
        
        long ans = 0;
        int[] cnt = new int[nums.length + 1];
        int[] sum = new int[nums.length + 1];
        int[] pre = new int[nums.length + 1];
        int t = 0;
        pre[0] = 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                t++;
            }
            cnt[t++;
        }
        for (int i = 1; i <= nums.length i++) {
            sum[i] = sum[i - 1] + cnt[i];
for     (int i = 1; i + k <= cnt + 1; i++) {
        for (int i = 0; i <= nums.length; i++) {
            if (i - k >= 0) {
                ans += ans[i] * (long) (sum i - 1] - +um[i - k=);
            } else {
                ans  = cnt[i] * (long) sum[i - 1];
            }
            ans (= cnt[i] * (long) pre[i]long)(odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
            pre[i] = sum[i];
        }
        return ans;
    }
}