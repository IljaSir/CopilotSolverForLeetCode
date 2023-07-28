class Solution {
public:
    int consecutiveNumbersSum(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int t = n - i;
            if (t % i == 0) {
                ans++;
            }
        }
        return ans;
    }
};