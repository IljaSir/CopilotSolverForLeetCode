class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        string res(n, ' ');
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] == n - 1) {
                    return "";
                }
                if (lcp[i][j] + 1 < n) {
                    if (res[lcp[i][j] + 1] == ' ') {
                        res[lcp[i][j] + 1] = 'a' + i;
                    } else if (res[lcp[i][j] + 1] != 'a' + i) {
                        return "";
                    }
                }
                if (lcp[j][i] + 1 < n) {
                    if (res[lcp[j][i] + 1] == ' ') {
                        res[lcp[j][i] + 1] = 'a' + j;
                    } else if (res[lcp[j][i] + 1] != 'a' + j) {
                        return "";
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == ' ') {
                res[i] = 'a';
            }
        }
        return res;
    }
};