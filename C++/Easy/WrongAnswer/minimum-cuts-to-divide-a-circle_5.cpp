class Solution {
public:
    int numberOfCuts(int n) {
        
        int ans = 0;
        while (n > 2) {
            ans += 1;
            n -= 2;
        }
        return ans;
    }
    int minNumberOfCuts(int n) {
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            ans += numberOfCuts(i);
        }
        return ans;
    }
};