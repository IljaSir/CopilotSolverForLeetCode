class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        vector<vector<int>> m(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (statements[i][j] == 1) {
                    m[i][j] = 1;
                }
            }
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (m[i][k] == 1 && m[k][j] == 1) {
                        m[i][j] = 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (m[i][j] == 1) {
                    ++count;
                }
            }
            if (count == n - 1) {
                ++res;
            }
        }
        return res;
    }
};