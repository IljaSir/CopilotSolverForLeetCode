class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        int m = statements[0].size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            vector<int> good(n, 1);
            good[i] = 0;
            for (int j = 0; j < m; j++) {
                if (statements[i][j] == 0) {
                    good[j] = 0;
                }
                if (statements[i][j] == 1) {
                    good[j] = 1;
                }
            }
            for (int j = 0; j < m; j++) {
                if (statements[j][i] == 1) {
                    good[j] = 1;
                }
                if (statements[j][i] == 0) {
                    good[j] = 0;
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (good[j]) cnt++;
            }
            res = max(res, cnt);
        }
        return res;
    }
};