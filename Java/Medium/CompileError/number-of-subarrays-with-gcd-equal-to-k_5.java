class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int x = nums[i] % k;
            if (x < 0) x += k;
            cnt[x]++;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (cnt[i] > 0) {
                for (int j = i; j <= k; j++) {
                    if (gcd(i, j) == 1) {
                        ans += cnt[i] * cnt[j];
                    }
                }
            }
        }
        return ans + cnt[0] * (cnt[0] + 1) / 2;
    }
}