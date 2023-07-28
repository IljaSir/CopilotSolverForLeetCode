class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int n = nums.size();
        int max = nums[0];
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != maxIdx && max < nums[i] * 2) {
                return -1;
            }
        }
        return maxIdx;
    }
};