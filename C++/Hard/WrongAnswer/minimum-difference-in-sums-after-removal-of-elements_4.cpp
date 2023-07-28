class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        long long sum = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        long long ans = sum;
        long long sum1 = 0;
        for (int i = 0; i < n; ++i) {
            sum1 += nums[i];
            long long sum2 = sum - sum1;
            ans = min(ans, abs(sum1 - sum2));
            if (i >= n / 2) {
                sum1 -= nums[i - n / 2];
            }
        }
        return ans;
    }
};