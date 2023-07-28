class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> ans;
        if (numRows == 0) return ans;
        ans.push_back({1});
        if (numRows == 1) return ans;
        ans.push_back({1,1});
        if (numRows == 2) return ans;
        for (int i = 2; i < numRows; ++i) {
            vector<int> row;
            for (int j = 0; j <= i; ++j) {
                int val = 0;
                if (j - 1 >= 0) val += ans[i-1][j-1];
                if (j < ans[i-1].size()) val += ans[i-1][j];
                row.push_back(val);
            }
            ans.push_back(row);
        }
        return ans;
    }
};