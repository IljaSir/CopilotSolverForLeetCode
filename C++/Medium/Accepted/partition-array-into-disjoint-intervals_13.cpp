class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        
        int n = nums.size();
        int leftMax = nums[0];
        int curMax = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < leftMax) {
                leftMax = curMax;
                res = i;
            } else {
                curMax = max(curMax, nums[i]);
            }
        }
        return res + 1;
    }
};