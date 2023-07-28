class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        
        int n = colsum.size();
        vector<vector<int>> ans(2, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            if (colsum[i] == 2) {
                ans[0][i] = 1;
                ans[1][i] = 1;
                upper--;
                lower--;
            }
        }
        if (upper < 0 || lower < 0) return {};
        for (int i = 0; i < n; ++i) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    ans[0][i] = 1;
                    upper--;
                }
                else if (lower > 0) {
                    ans[1][i] = 1;
                    lower--;
                }
                else return {};
            }
        }
        return ans;
    }
};