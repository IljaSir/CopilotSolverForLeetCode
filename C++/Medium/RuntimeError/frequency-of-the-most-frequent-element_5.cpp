class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(begin(nums), end(nums));
        int n = nums.size();
        long long total = 0;
        int ans = 1;
        for (int i = 0, j = 0; i < n; ++i) {
            total += nums[i];
            while (j <= i && nums[i] * (i - j + 1) - total > k) {
                total -= nums[j++];
            }
            ans = max(ans, i - j + 1);
        }
        return ans;
    }
};