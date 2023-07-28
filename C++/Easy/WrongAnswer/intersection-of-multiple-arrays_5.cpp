class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> res;
        unordered_map<int, int> m;
        for (auto& n : nums) {
            for (auto& i : n) {
                ++m[i];
                if (m[i] == nums.size()) {
                    res.push_back(i);
                }
            }
        }
        return res;
    }
};