class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (i != maxIndex && max < nums[i] * 2) {
                return -1;
            }
        }
        return maxIndex;
    }
};