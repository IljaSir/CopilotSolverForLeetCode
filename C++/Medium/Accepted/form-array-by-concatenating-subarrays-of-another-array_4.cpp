class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0;
        for (auto& group : groups) {
            int j = 0;
            while (i < nums.size() && j < group.size()) {
                if (nums[i] == group[j]) {
                    ++i;
                    ++j;
                }
                else {
                    i = i - j + 1;
                    j = 0;
                }
            }
            if (j != group.size()) {
                return false;
            }
        }
        return true;
    }
};