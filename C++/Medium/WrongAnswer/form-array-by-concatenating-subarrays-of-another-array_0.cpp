class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0, j = 0;
        while (i < groups.size() && j < nums.size()) {
            if (groups[i][0] != nums[j]) {
                j++;
                continue;
            }
            int k = 0;
            while (k < groups[i].size() && j < nums.size() && groups[i][k] == nums[j]) {
                k++;
                j++;
            }
            if (k == groups[i].size()) {
                i++;
            }
        }
        return i == groups.size();
    }
};