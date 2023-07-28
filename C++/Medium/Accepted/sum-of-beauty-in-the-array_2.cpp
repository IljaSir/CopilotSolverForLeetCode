class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> left(n);
        vector<int> right(n);
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = max(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = min(right[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
};