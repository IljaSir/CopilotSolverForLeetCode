class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size(), n = bank[0].size();
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                sum += bank[i][j] - '0';
            }
            ans += sum * (sum - 1) / 2;
        }
        return ans;
    }
};