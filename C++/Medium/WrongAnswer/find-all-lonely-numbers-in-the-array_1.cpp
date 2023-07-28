class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        if (n == 1) {
            res.push_back(nums[0]);
            return res;
        }
        if (nums[0] != nums[1]) {
            res.push_back(nums[0]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                res.push_back(nums[i]);
            }
        }
        if (nums[n - 1] != nums[n - 2]) {
            res.push_back(nums[n - 1]);
        }
        return res;
    }
};