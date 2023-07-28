class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int n = groups.size();
        int m = nums.size();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m) {
            if (nums[j] == groups[i][k]) {
                k++;
                if (k == groups[i].size()) {
                    i++;
                    k = 0;
                }
                j++;
            } else {
                j = j - k + 1;
                k = 0;
            }
        }
        return i == n;
    }
};