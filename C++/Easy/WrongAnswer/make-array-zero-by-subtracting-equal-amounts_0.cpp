class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int res = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] > nums[i-1]) {
                res += nums[i] - nums[i-1];
            }
        }
        return res;
    }
};