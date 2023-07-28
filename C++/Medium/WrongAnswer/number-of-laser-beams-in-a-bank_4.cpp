class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size(), n = bank[0].size();
        vector<int> cnt(n, 0);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int left = -1, right = -1;
            for (int j = 0; j < n; ++j) {
                if (bank[i][j] == '1') {
                    if (left == -1) {
                        left = j;
                    }
                    right = j;
                }
            }
            if (left != -1) {
                for (int j = left; j <= right; ++j) {
                    if (bank[i][j] == '0') {
                        ++cnt[j];
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            ans += cnt[i];
        }
        return ans;
    }
};