class Solution {
public:
    int distinctIntegers(int n) {
        
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int t = n / i;
            ans += t;
            if (t * i == n) {
                ans--;
            }
        }
        return ans;
    }
};