class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size();
        std::sort(nums.begin(), nums.end());
        int k = (nums[n/2] - nums[n/2 - 1]) / 2;
        for (int i = 0; i < n; i++) {
            nums[i] -= k;
        }
        return nums;
    }
};