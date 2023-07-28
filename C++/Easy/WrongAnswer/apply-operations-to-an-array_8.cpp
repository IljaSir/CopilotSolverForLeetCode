class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res.push_back(nums[i] * 2);
                i++;
            } else {
                res.push_back(nums[i]);
            }
        }
        if (n > 1) res.push_back(nums[n - 1]);
        return res;
    }
};