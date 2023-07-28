class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        unordered_map<int, int> mp;
        for (auto &v : nums) {
            for (auto &n : v) {
                ++mp[n];
            }
        }
        vector<int> res;
        for (auto &p : mp) {
            if (p.second == nums.size()) {
                res.push_back(p.first);
            }
        }
        return res;
    }
};