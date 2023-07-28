class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                cur++;
                if (cur > max) {
                    max = cur;
                }
            } else {
                cur = 0;
            }
        }
        return max;
    }
};