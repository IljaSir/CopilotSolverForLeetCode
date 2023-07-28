class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int ans = 1, n = nums.size();
        long long sum = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            sum += nums[i];
            while (sum + k < (long long)nums[i] * (i - j + 1)) {
                sum -= nums[j++];
            }
            ans = max(ans, i - j + 1);
        }
        return ans;
    }
};