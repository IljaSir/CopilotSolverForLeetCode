class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 3;
        sort(nums.begin(), nums.end());
        long long sum = accumulate(nums.begin(), nums.end(), 0LL);
        long long ans = sum;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, sum - 2LL * accumulate(nums.begin() + i, nums.begin() + i + n, 0LL));
        }
        return ans;
    }
};