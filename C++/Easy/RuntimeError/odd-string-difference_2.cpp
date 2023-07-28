class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].size();
        vector<vector<int>> diff(n, vector<int>(m - 1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                diff[i][j] = words[i][j + 1] - words[i][j];
            }
        }
        for (int i = 0; i < m - 1; i++) {
            int cnt[26] = {0};
            for (int j = 0; j < n; j++) {
                cnt[diff[j][i] + 13]++;
            }
            for (int j = 0; j < n; j++) {
                if (cnt[diff[j][i] + 13] == 1) {
                    return words[j];
                }
            }
        }
        return "";
    }
};