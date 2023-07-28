class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return true;
        }
        int j = n - 1;
        while (j > 0 && nums[j] > nums[j - 1]) {
            j--;
        }
        if (i == 0 || j == n - 1) {
            return true;
        }
        if (nums[i - 1] < nums[i + 1] || nums[j - 1] < nums[j + 1]) {
            return true;
        }
        return false;
    }
};