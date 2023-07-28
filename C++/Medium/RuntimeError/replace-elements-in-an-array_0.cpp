class Solution {
public:
    vector<int> arrayChange(vector<int>& nums, vector<vector<int>>& operations) {
        
        int n = nums.size();
        vector<int> res(n, 0);
        for (auto op : operations) {
            int l = op[0] - 1;
            int r = op[1] - 1;
            res[l]++;
            if (r + 1 < n) {
                res[r + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
};