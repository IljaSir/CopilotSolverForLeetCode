class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = gcd(pre[i], nums[i]);
        }
        int[] count = new int[k];
        for (int i = 1; i <= n; i++) {
            int g = pre[i];
            if (g > 1) {
                count[g]++;
            }
            for (int j = 2; j * j <= g; j++) {
                if (g % j == 0) {
                    count[j]++;
                    if (j * j != g) {
                        count[g / j]++;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < k; i++) {
            if (k % i == 0) {
                ans += count[i];
            }
        }
        return ans;
    }
}