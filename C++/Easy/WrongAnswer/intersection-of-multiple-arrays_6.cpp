class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        int n = nums.size();
        if (n == 0) return {};
        vector<int> res;
        unordered_map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                mp[nums[i][j]]++;
            }
        }
        for (auto it = mp.begin(); it != mp.end(); it++) {
            if (it->second == n) {
                res.push_back(it->first);
            }
        }
        return res;
    }
};