class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0;
        int j = 0;
        while (i < groups.size() && j < nums.size()) {
            if (nums[j] == groups[i][0]) {
                int k = 0;
                while (k < groups[i].size() && j < nums.size() && nums[j] == groups[i][k]) {
                    k++;
                    j++;
                }
                if (k == groups[i].size()) {
                    i++;
                } else {
                    j = j - k + 1;
                }
            } else {
                j++;
            }
        }
        return i == groups.size();
    }
};