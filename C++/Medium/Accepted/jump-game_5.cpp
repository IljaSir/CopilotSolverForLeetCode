class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int len = nums.size();
        int reach = 0;
        for (int i = 0; i < len; i++) {
            if (i > reach) {
                return false;
            }
            reach = max(reach, i + nums[i]);
            if (reach >= len - 1) {
                return true;
            }
        }
        return false;
    }
};