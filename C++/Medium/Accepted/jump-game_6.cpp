class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int maxReach = 0;
        while (i < n && i <= maxReach) {
            maxReach = max(maxReach, i + nums[i]);
            i++;
        }
        return i == n;
    }
};