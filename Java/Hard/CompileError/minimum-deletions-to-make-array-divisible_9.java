class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int n = nums.length;
        int m = numsDivide.length;
        int[] cnt = new int[m];
        int[] freq = new int[1000001];
        int ans = 0;
        for (int i = 0; i < n; i++) freq[nums[i]]++;
        for (int i = 0; i < m; i++) {
            cnt[i] = freq[numsDivide[i]];
            if (cnt[i] == 0) return -1;
        }
        int gcd = numsDivide[0];
        for (int i = 1; i < m; i++) gcd = gcd(gcd, numsDivide[i]);
        for (int i = 0; i < m; i++) {
            ans += cnt[i] - 1;
            numsDivide[i] /= gcd;
        }
        int lcm = numsDivide[0];
        for (int i = 1; i < m; i++) lcm = lcm(lcm, numsDivide[i]);
        if (lcm == 1) return ans;
        return -1;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}