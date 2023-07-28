class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        
        vector<int> zeros(grid.size(), 0);
        for (int i = 0; i < grid.size(); ++i) {
            int j = grid.size() - 1;
            while (j >= 0 && grid[i][j] == 0) {
                ++zeros[i];
                --j;
            }
        }
        int res = 0;
        for (int i = 0; i < zeros.size(); ++i) {
            if (zeros[i] >= zeros.size() - i - 1) continue;
            int j = i + 1;
            while (j < zeros.size() && zeros[j] < zeros.size() - i - 1) ++j;
            if (j == zeros.size()) return -1;
            while (j > i) {
                swap(zeros[j], zeros[j - 1]);
                --j;
                ++res;
            }
        }
        return res;
    }
};