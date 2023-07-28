class Solution {
public:
    int countOrders(int n) {
        
        long long ans = 1;
        for (int i = 1; i <= n; ++i) {
            ans = ans * (i * 2 - 1) * (i * 2) % 1000000007;
        }
        return ans;
    }
};