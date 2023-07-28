class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int s = 0;
        for (int i = 0; i < n-1; i++) {
            s += abs(nums[i] - nums[i+1]);
        }
        return s;
    }
};