class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        int[] rem = new int[n];
        int[] cnt = new int[p];
        for (int i = 0; i < n; ++i) {
            rem[i] = nums[i] % p;
            pre[i] = (i > 0 ? pre[i - 1] : 0) + rem[i];
            cnt[pre[i] % p]++;
        }
        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                cnt[pre[i - k - 1] % p]--;
            }
            res[i] = cnt[pre[i] % p];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += res[i];
            if (rem[i] == 0) {
                ans++;
            }
        }
        return ans;
    }
}