class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n + 1, 0);
        cnt[0] = 1;
        long long res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum - k >= 0) {
                res += cnt[sum - k];
            }
            cnt[sum]++;
        }
        return res;
    }
};