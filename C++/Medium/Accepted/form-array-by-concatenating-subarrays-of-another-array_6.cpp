class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0, j = 0, k;
        while (i < groups.size()) {
            while (j < nums.size()) {
                k = 0;
                while (k < groups[i].size() && j + k < nums.size() && nums[j + k] == groups[i][k]) ++k;
                if (k == groups[i].size()) break;
                ++j;
            }
            if (j == nums.size()) break;
            ++i;
            j += groups[i - 1].size();
        }
        return i == groups.size();
    }
};