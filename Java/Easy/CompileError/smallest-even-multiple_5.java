class Solution {
    public int smallestEvenMultiple(int n) {
        
        int ans = 1;
        for (int i = 1; i <= n; ++i) {
            ans = lcm(ans, i);
        }
        return ans;
    }
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}