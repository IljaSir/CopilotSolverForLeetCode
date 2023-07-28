class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int maxPos = 0;
        while (i < n && i <= maxPos) {
            maxPos = max(maxPos, i + nums[i]);
            i++;
        }
        return i == n;
    }
};