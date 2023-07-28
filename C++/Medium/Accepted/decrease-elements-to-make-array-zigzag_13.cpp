class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i += 2) {
            int left = i - 1 >= 0 ? nums[i - 1] : 1000;
            int right = i + 1 < n ? nums[i + 1] : 1000;
            int min = left < right ? left : right;
            if (nums[i] >= min) {
                even += nums[i] - min + 1;
            }
        }
        for (int i = 1; i < n; i += 2) {
            int left = i - 1 >= 0 ? nums[i - 1] : 1000;
            int right = i + 1 < n ? nums[i + 1] : 1000;
            int min = left < right ? left : right;
            if (nums[i] >= min) {
                odd += nums[i] - min + 1;
            }
        }
        return odd < even ? odd : even;
    }
};