class Solution {
    public int consecutiveNumbersSum(int n) {
        
        int ans = 0;
        for (int i = 1; i * (i - 1) / 2 < n; i++) {
            int t = (n - i * (i - 1) / 2);
            if (t % i == 0) ans++;
        }
        return ans;
    }
}