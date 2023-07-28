class Solution {
public:
    int numOfWays(int n) {
        
        int mod = 1000000007;
        long long same = 6, diff = 6;
        for (int i = 2; i <= n; i++) {
            long long same_temp = same;
            same = (3 * same_temp + 2 * diff) % mod;
            diff = (2 * same_temp + 2 * diff) % mod;
        }
        return (same + diff) % mod;
    }
};