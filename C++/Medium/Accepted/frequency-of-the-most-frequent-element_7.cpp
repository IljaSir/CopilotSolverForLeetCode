class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0;
        int r = 0;
        int64_t sum = 0;
        int ans = 0;
        while (r < n) {
            sum += nums[r];
            while (sum + k < (int64_t)nums[r] * (r - l + 1)) {
                sum -= nums[l];
                ++l;
            }
            ans = max(ans, r - l + 1);
            ++r;
        }
        return ans;
    }
};