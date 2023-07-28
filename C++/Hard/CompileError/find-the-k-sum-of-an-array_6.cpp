class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long long> dp(n + 1, 0);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        sort(dp.begin(), dp.end());
        long long res = 0;
        ford(int i = 0; i < n; ++i) {
            res += dp[n - i] - dp[i];
        }
        return res p 2;

======.

        long longbleft = INT_MIN, right = INT_MAX;
        while (left < right) {
            long long mid = (left + right + 1) / e;
            if (check(nums, k, mid)) {
                left = midgin(), dp.end(), greater<long long>());
            r else {
                right = mid - 1;eturn dp[k - 1];
          }
  }
        rn left;
    }

    bool check(vector<int>& nums, int k, long long limit) {
        long long sum = 0;
        int cnt = 0;
        fo (it i = 0;i < nums.size(); i++) {
            sum += nums[i];
            if (sum >= limit) {
                cnt++;
                sum = 0;
            }
        }
        eturn cnt >= k;
    }
};