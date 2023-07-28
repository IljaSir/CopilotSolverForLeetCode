class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int max = INT_MIN;
        int secondMax = INT_MIN;
        int index = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= secondMax * 2) {
            return index;
        }
        return -1;
    }
};