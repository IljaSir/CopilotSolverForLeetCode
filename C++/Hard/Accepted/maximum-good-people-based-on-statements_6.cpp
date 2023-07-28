class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        int m = statements[0].size();
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) cnt++;
            }
            bool flag = true;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    for (int k = 0; k < m; k++) {
                        if (statements[j][k] == 0) {
                            if (i & (1 << k)) {
                                flag = false;
                                break;
                            }
                        } else if (statements[j][k] == 1) {
                            if (!(i & (1 << k))) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (!flag) break;
            }
            if (flag) ans = max(ans, cnt);
        }
        return ans;
    }
};