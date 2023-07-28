class Solution {
public:
    bool check(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        for (; i < n - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }
        int j = i + 1;
        for (; j < n - 1; ++j) {
            if (nums[j] > nums[j + 1]) {
                break;
            }
        }
        if (j == n - 1 && nums[i] > nums[j]) {
            return true;
        }
        return false;
    }
};