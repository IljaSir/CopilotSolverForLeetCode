class Solution {
public:
    int smallestRangeII(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int high = max(nums[n - 1] - k, a + k);
            int low = min(nums[0] + k, b - k);
            ans = min(ans, high - low);
        }
        return ans;
    }
};