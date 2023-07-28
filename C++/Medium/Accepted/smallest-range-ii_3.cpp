class Solution {
public:
    int smallestRangeII(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int ans = nums.back() - nums.front();
        for (int i = 0; i < nums.size() - 1; ++i) {
            int a = nums[i], b = nums[i + 1];
            int high = max(nums.back() - k, a + k);
            int low = min(nums.front() + k, b - k);
            ans = min(ans, high - low);
        }
        return ans;
    }
};