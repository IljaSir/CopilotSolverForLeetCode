class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int ans = 0;
        int forgetDay = 0;
        for (int i = 1; i <= n; i++) {
            if (i == forgetDay) {
                ans -= delay;
            }
            ans += delay;
            forgetDay += forget;
        }
        return ans;
    }
};