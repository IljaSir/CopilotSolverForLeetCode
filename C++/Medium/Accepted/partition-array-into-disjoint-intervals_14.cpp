class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        
        int n = nums.size();
        int leftMax = nums[0];
        int maxSoFar = nums[0];
        int partitionIndex = 0;
        for (int i = 1; i < n; ++i) {
            maxSoFar = max(maxSoFar, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = maxSoFar;
                partitionIndex = i;
            }
        }
        return partitionIndex + 1;
    }
};