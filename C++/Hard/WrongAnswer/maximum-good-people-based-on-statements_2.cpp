class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        vector<int> good(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (statements[i][j] == 2) {
                    continue;
                }
                if (statements[i][j] == 1) {
                    good[i] |= (1 << j);
                } else {
                    good[i] &= ~(1 << j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            bool flag = true;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) && ((i & good[j]) != good[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = max(ans, __builtin_popcount(i));
            }
        }
        return ans;
    }
};