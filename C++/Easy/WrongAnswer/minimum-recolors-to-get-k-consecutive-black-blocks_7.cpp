class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> dp(n, 0);
        int l = 0, r = 0;
        int cnt = 0;
        while (r < n) {
            if (blocks[r] == 'W') {
                cnt++;
            }
            while (cnt > k) {
                if (blocks[l] == 'W') {
                    cnt--;
                }
                l++;
            }
            dp[r] = l;
            r++;
        }
        vector<int> dp2(n, 0);
        l = n - 1, r = n - 1;
        cnt = 0;
        while (l >= 0) {
            if (blocks[l] == 'W') {
                cnt++;
            }
            while (cnt > k) {
                if (blocks[r] == 'W') {
                    cnt--;
                }
                r--;
            }
            dp2[l] = r;
            l--;
        }
        int res = INT_MAX;
        for (int i = 0; i + k - 1 < n; i++) {
            res = min(res, dp[i + k - 1] - dp[i] + dp2[i + k - 1] - dp2[i]);
        }
        return res;
    }
};