class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> good(n, 1);
            good[i] = 0;
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 0) {
                    good[j] = 0;
                }
                if (statements[i][j] == 2) {
                    good[j] = -1;
                }
            }
            for (int j = 0; j < n; j++) {
                if (statements[j][i] == 1) {
                    good[j] = 0;
                }
                if (statements[j][i] == 2) {
                    good[j] = -1;
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += good[j];
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};