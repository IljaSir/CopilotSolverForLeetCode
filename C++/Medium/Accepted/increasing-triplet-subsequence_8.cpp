class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        int min = nums[0], mid = INT_MAX;
        for (int i = 1; i < n; i++) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] > min) {
                mid = nums[i];
            } else {
                min = nums[i];
            }
        }
        return false;
    }
};