class Solution {
    public int countOrders(int n) {
        
        int mod = 1000000007;
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (int) (((long) ans * i * (2 * i - 1)) % mod);
        }
        return ans;
    }
}