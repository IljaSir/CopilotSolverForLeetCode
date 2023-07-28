class Solution {
public:
    vector<int> arrayChange(vector<int>& nums, vector<vector<int>>& operations) {
        
        int n = nums.size();
        int m = operations.size();
        vector<int> res(n);
        for (int i = 0; i < m; i++) {
            int idx = operations[i][0];
            int val = operations[i][1];
            if (idx > 0) {
                res[idx-1] -= val;
            }
            if (idx < n) {
                res[idx] += val;
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i-1];
        }
        for (int i = 0; i < n; i++) {
            res[i] += nums[i];
        }
        return res;
    }
};