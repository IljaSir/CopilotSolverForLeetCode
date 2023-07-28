class Solution {
    public int countOrders(int n) {
        
        int mod = 1000000007;
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i) % mod;
            res = (res * (2 * i - 1)) % mod;
        }
        return (int) res;
    }
}