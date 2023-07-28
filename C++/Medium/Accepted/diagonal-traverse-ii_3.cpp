class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int n = nums.size();
        vector<int> ans;
        map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < nums[i].size(); ++j) {
                m[i + j].push_back(nums[i][j]);
            }
        }
        for (auto& p : m) {
            for (int i = p.second.size() - 1; i >= 0; --i) {
                ans.push_back(p.second[i]);
            }
        }
        return ans;
    }
};