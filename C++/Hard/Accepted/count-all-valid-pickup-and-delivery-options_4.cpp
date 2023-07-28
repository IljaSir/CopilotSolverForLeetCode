class Solution {
public:
    int countOrders(int n) {
        
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * (long long)(i) * (2 * i - 1)) % 1000000007;
        }
        return res;
    }
};