class Solution {
public:
    string oddString(vector<string>& words) {
        
        int n = words.size(), m = words[0].size();
        vector<vector<int>> diff(n, vector<int>(m - 1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                diff[i][j] = words[i][j+1] - words[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            bool isOdd = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (diff[i] == diff[j]) {
                    isOdd = false;
                    break;
                }
            }
            if (isOdd) return words[i];
        }
        return "";
    }
};