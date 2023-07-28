class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        
        vector<vector<int>> ans(2, vector<int>(colsum.size(), 0));
        int sum = 0;
        for (auto i : colsum) sum += i;
        if (sum != upper + lower) return {};
        for (int i = 0; i < colsum.size(); ++i) {
            if (colsum[i] == 2) {
                ans[0][i] = ans[1][i] = 1;
                upper--;
                lower--;
            }
        }
        if (upper < 0 || lower < 0) return {};
        for (int i = 0; i < colsum.size(); ++i) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    ans[0][i] = 1;
                    upper--;
                } else if (lower > 0) {
                    ans[1][i] = 1;
                    lower--;
                } else {
                    return {};
                }
            }
        }
        return ans;
    }
};