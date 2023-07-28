class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> right(n);
        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; --i) {
            right[i] = min(nums[i], right[i+1]);
        }
        int left = nums[0];
        int ans = 0;
        for (int i = 1; i < n-1; ++i) {
            if (left < nums[i] && nums[i] < right[i+1]) {
                ans += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                ans += 1;
            }
            left = max(left, nums[i]);
        }
        return ans;
    }
};