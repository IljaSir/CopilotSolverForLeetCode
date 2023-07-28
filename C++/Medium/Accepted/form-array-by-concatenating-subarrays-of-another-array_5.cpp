class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0;
        for (auto &group : groups) {
            bool found = false;
            for (; i <= nums.size() - group.size(); ++i) {
                if (nums[i] == group[0]) {
                    found = true;
                    for (int j = 1; j < group.size(); ++j) {
                        if (nums[i + j] != group[j]) {
                            found = false;
                            break;
                        }
                    }
                }
                if (found) {
                    i += group.size();
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
};