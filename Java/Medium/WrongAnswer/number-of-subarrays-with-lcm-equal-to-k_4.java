class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = gcd(prefix[i], nums[i]);
        }
        int[] count = new int[k+1];
        for (int i = 1; i <= n; i++) {
            if (prefix[i] > 1) {
                count[prefix[i]]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (k % i == 0) {
                ans += count[i];
            }
        }
        return ans;
    }
    private int gcd(int a, int b) {
        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}