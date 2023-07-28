class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return true;
        int maxReach = nums[0];
        for (int i = 1; i < n; i++) {
            if (maxReach >= i) {
                maxReach = max(maxReach, i + nums[i]);
                if (maxReach >= n - 1) return true;
            }
        }
        return false;
    }
};