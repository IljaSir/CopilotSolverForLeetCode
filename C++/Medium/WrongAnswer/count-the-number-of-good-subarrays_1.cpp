class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n + 1);
        cnt[0] = 1;
        int sum = 0;
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum >= k) {
                ans += cnt[sum - k];
            }
            ++cnt[sum];
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            nums[i] &= 1;
        }
        return countGood(nums, k) - countGood(nums, k - 1);
    }
};