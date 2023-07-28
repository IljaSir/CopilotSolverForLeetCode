class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int n = nums.size();
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxPos) {
                maxPos = max(maxPos, i + nums[i]);
                if (maxPos >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
};