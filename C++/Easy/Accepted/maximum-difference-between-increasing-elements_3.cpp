class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        
        int n = nums.size();
        int maxDiff = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > nums[i]) {
                    maxDiff = max(maxDiff, nums[j] - nums[i]);
                }
            }
        }
        return maxDiff;
    }
};