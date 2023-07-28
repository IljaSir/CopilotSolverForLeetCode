class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int max = 0, secondMax = 0, maxIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= 2 * secondMax ? maxIndex : -1;
    }
};