class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0;
        for (auto &group : groups) {
            auto it = search(nums.begin() + i, nums.end(), group.begin(), group.end());
            if (it == nums.end()) return false;
            i = distance(nums.begin(), it) + group.size();
        }
        return true;
    }
};