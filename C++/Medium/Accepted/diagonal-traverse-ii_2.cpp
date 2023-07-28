class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int n = nums.size();
        vector<int> ans;
        map<int, vector<int>> mp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                mp[i + j].push_back(nums[i][j]);
            }
        }
        for (auto& p : mp) {
            vector<int>& v = p.second;
            int m = v.size();
            for (int i = m - 1; i >= 0; i--) {
                ans.push_back(v[i]);
            }
        }
        return ans;
    }
};