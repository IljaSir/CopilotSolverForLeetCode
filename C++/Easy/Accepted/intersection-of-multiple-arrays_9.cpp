class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> result;
        std::map<int, int> map;
        for (auto &v : nums) {
            for (auto &i : v) {
                map[i]++;
            }
        }
        for (auto &i : map) {
            if (i.second == nums.size()) {
                result.push_back(i.first);
            }
        }
        return result;
    }
};