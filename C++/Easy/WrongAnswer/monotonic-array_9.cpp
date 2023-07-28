class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) {
            return true;
        }
        bool inc = nums[0] <= nums[1];
        for (int i = 2; i < n; i++) {
            if (inc) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
};