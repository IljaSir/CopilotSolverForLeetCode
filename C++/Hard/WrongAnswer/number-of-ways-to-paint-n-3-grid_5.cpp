class Solution {
public:
    int numOfWays(int n) {
        
        long long int same = 6, diff = 6, mod = 1000000007;
        for(int i = 2; i <= n; i++) {
            long long int temp = same;
            same = diff;
            diff = (temp * 2 + diff * 3) % mod;
        }
        return (same + diff) % mod;
    }
};