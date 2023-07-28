class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int ans = 0;
        int m = bank.size();
        int n = bank[0].size();
        for (int j = 0; j < n; ++j) {
            int i = 0;
            while (i < m && bank[i][j] == '0') ++i;
            if (i == m) continue;
            ++ans;
            while (i < m && bank[i][j] == '1') ++i;
            while (i < m && bank[i][j] == '0') ++i;
            if (i < m) ++ans;
        }
        return ans;
    }
};