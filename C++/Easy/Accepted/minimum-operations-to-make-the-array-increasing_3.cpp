class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int res = 0, pre = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] <= pre) {
                res += pre - nums[i] + 1;
                pre++;
            } else {
                pre = nums[i];
            }
        }
        return res;
    }
};