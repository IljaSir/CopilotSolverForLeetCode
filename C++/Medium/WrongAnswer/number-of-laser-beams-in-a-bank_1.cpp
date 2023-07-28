class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size(), n = bank[0].size();
        vector<int> row(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i][j] == '1') {
                    row[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (row[j] > row[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }
};