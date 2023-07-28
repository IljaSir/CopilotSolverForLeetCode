class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int i = 0, j = nums.size() - 1;
        while (i < nums.size() - 1 && nums[i] <= nums[i + 1]) i++;
        while (j > 0 && nums[j] >= nums[j - 1]) j--;
        if (i >= j) return 0;
        int min = nums[i], max = nums[i];
        for (int k = i; k <= j; k++) {
            if (nums[k] < min) min = nums[k];
            if (nums[k] > max) max = nums[k];
        }
        while (i > 0 && nums[i - 1] > min) i--;
        while (j < nums.size() - 1 && nums[j + 1] < max) j++;
        return j - i + 1;
    }
};