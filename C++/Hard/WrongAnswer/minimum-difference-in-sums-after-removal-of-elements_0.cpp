class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 3;
        sort(nums.begin(), nums.end());
        long long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; ++i) {
            sum1 += nums[i];
            sum2 += nums[n + i];
        }
        long long res = sum2 - sum1;
        for (int i = n; i < 2 * n; ++i) {
            sum1 += nums[i] - nums[i - n];
            sum2 -= nums[i] - nums[i - n];
            res = min(res, abs(sum1 - sum2));
        }
        return res;
    }
};