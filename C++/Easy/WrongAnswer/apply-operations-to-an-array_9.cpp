class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n, 0);
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (j == n - 1 || nums[j] != nums[j + 1]) {
                res[i++] = nums[j];
            } else {
                res[i++] = nums[j] * 2;
                ++j;
            }
        }
        return res;
    }
};