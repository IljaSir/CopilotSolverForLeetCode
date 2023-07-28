class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        
        int n = nums.size();
        int i = 1;
        while (i < n && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == n) {
            return true;
        }
        int inc = nums[i] > nums[i - 1];
        for (; i < n; i++) {
            if (inc && nums[i] < nums[i - 1]) {
                return false;
            }
            if (!inc && nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
};