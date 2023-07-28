class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int ans = 0;
        int n = pieces.size();
        int m = 1 << n;
        for (int i = 0; i < m; i++) {
            vector<int> cnt(8, 0);
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    cnt[positions[j][0] - 1]++;
                    cnt[positions[j][1] + 7]++;
                    if (pieces[j] == "bishop") {
                        cnt[positions[j][0] - positions[j][1] + 15]++;
                        cnt[positions[j][0] + positions[j][1]]++;
                    }
                    if (pieces[j] == "queen") {
                        cnt[positions[j][0] - positions[j][1] + 15]++;
                        cnt[positions[j][0] + positions[j][1]]++;
                        cnt[positions[j][0] - 1]++;
                        cnt[positions[j][1] + 7]++;
                    }
                }
            }
            bool flag = true;
            for (int j = 0; j < 8; j++) {
                if (cnt[j] > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
};