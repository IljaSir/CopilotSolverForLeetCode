class Solution {
    public int countOrders(int n) {
        
        int mod = 1000000007;
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i * (2 * i - 1) % mod;
        }
        return (int) res;
    }
}