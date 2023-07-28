class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 3;
        sort(nums.begin(), nums.end());
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long long sumfirst = 0;
        long long sumsecond = 0;
        long long res = 1e18;
        for (int i = 0; i < n; i++) {
            sumfirst += nums[i];
            sumsecond += nums[n + i];
            res = min(res, (sum - sumfirst - sumsecond) - (sumfirst - sumsecond));
        }
        return res;
    }
};