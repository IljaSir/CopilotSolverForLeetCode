class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int m = nums.size();
        int n = 0;
        for (int i = 0; i < m; i++) {
            n = max(n, (int)nums[i].size());
        }
        vector<vector<int>> mat(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                mat[i][j] = nums[i][j];
            }
        }
        vector<int> ans;
        for (int i = 0; i < m + n - 1; i++) {
            vector<int> tmp;
            for (int j = 0; j <= i; j++) {
                int x = j;
                int y = i - j;
                if (x >= m || y >= n) continue;
                if (mat[x][y] != 0) {
                    tmp.push_back(mat[x][y]);
                }
            }
            if (i % 2 == 0) {
                reverse(tmp.begin(), tmp.end());
            }
            for (int j = 0; j < tmp.size(); j++) {
                ans.push_back(tmp[j]);
            }
        }
        return ans;
    }
};