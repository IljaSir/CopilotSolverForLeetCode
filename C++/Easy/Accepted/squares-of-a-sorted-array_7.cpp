class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n && nums[i] < 0) ++i;
        int j = i - 1;
        vector<int> res;
        while (i < n && j >= 0) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res.push_back(nums[i] * nums[i]);
                ++i;
            } else {
                res.push_back(nums[j] * nums[j]);
                --j;
            }
        }
        while (i < n) {
            res.push_back(nums[i] * nums[i]);
            ++i;
        }
        while (j >= 0) {
            res.push_back(nums[j] * nums[j]);
            --j;
        }
        return res;
    }
};