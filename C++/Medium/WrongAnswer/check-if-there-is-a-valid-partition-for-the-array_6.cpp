class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, 0), right(n, 0);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i + 1]) {
                if (left[i - 1] >= 2 || right[i + 1] >= 2) {
                    return true;
                }
            }
        }
        for (int i = 2; i < n - 2; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] + 1) {
                if (nums[i + 1] == nums[i] + 1 && nums[i + 2] == nums[i] + 1) {
                    return true;
                }
            }
        }
        return false;
    }
};