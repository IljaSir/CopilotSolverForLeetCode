class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int n = groups.size();
        int m = nums.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int k = 0;
            while (k < groups[i].size() && j < m && nums[j] == groups[i][k]) {
                j++;
                k++;
            }
            if (k == groups[i].size()) {
                i++;
            } else {
                j = j - k + 1;
            }
        }
        return i == n;
    }
};