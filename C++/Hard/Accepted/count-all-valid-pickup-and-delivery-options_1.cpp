class Solution {
public:
    int countOrders(int n) {
        
        long long result = 1;
        for (int i = 1; i <= n; ++i) {
            result = (result * i * (2 * i - 1)) % 1000000007;
        }
        return result;
    }
};