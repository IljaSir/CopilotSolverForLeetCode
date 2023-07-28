class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        
        int min = 10000;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int diff = max - min;
        if (diff < k * 2) {
            return 0;
        } else {
            return diff - k * 2;
        }
    }
};