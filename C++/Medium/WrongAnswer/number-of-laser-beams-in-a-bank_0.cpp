class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int cnt = 0;
            for (int i = 0; i < m; ++i) {
                if (bank[i][j] == '1') {
                    ++cnt;
                }
            }
            ans += cnt * (cnt - 1) / 2;
        }
        return ans;
    }
};