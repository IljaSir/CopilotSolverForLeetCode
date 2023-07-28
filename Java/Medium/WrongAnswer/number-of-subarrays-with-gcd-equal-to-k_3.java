class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k+1];
        for (int i = 0; i < n; i++) {
            cnt[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (cnt[i] > 0) {
                for (int j = i; j <= k; j++) {
                    if (gcd(i, j) == k) {
                        ans += cnt[i] * cnt[j];
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}