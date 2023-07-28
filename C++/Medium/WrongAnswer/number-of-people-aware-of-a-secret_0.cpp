class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (i - delay > 0) {
                ans = (ans + 1) % 1000000007;
            }
            if (i - forget - 1 > 0) {
                ans = (ans - 1 + 1000000007) % 1000000007;
            }
        }
        return ans;
    }
};