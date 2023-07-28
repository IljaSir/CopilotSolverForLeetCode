class Solution {
    public int countOrders(int n) {
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i * (2 * i - 1)) % 1000000007;
        }
        return (int) result;
    }
}