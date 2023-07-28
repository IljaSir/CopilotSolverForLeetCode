class Solution {
public:
    int consecutiveNumbersSum(int n) {
        
        int ans = 1;
        for (int k = 2; k * (k - 1) / 2 <= n; ++k) {
            if ((n - (k * (k - 1) / 2)) % k == 0) {
                ans++;
            }
        }
        return ans;
    }
};