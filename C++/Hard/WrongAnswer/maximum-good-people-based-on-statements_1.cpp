class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        vector<int> good(n, 0);
        vector<int> bad(n, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 1) {
                    good[i]++;
                    good[j]++;
                }
                if (statements[i][j] == 0) {
                    bad[i]++;
                    bad[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 1 || statements[i][j] == 0) {
                    if (good[j] > bad[j]) {
                        cnt++;
                    }
                }
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};