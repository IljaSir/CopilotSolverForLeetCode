class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        
        int n = nums.size(), sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) sum += nums[i];
            else if (i == n - 1 && nums[i] != nums[i - 1]) sum += nums[i];
            else if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) sum += nums[i];
        }
        return sum;
    }
};