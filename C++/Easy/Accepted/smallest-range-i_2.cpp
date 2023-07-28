class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        
        int min = INT_MAX, max = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int diff = max - min;
        return diff <= 2*k ? 0 : diff - 2*k;
    }
};