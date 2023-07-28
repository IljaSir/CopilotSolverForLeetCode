class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k + 1];
        for (int i = 0; i < n; i++) {
            cnt[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= k; j++) {
                if (gcd(i, j) == 1) {
                    ans += cnt[i] * cnt[j];
                }
            }
        }
        ans += cnt[1] * (cnt[1] + 1) / 2;
        return ans;
    }
    private int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b, a % b);
    }
}