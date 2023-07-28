class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size();
        int m = words[0].size();
        vector<vector<int>> diff(n, vector<int>(m - 1, 0));
        vector<int> diff2(m - 1, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                diff[i][j] = words[i][j + 1] - words[i][j];
                diff2[j] ^= diff[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            bool flag = true;
            for (int j = 0; j < m - 1; j++) {
                if (diff[i][j] != diff2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return words[i];
        }
        return "";
    }
};