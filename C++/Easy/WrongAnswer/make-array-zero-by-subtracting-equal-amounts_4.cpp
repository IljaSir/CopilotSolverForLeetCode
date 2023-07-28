class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int min = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (min == 0 || nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                continue;
            }
            count += nums[i] / min;
        }
        return count;
    }
};