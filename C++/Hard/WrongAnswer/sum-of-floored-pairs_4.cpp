class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        const int MOD = 1000000007;
        int n = nums.size();
        int maxVal = *max_element(nums.begin(), nums.end());
        vector<int> cnt(maxVal + 1);
        for (int x: nums) {
            cnt[x]++;
        }
        for (int i = 1; i <= maxVal; i++) {
            cnt[i] += cnt[i - 1];
        }
        long long ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            if (cnt[i] == n) {
                break;
            }
            int total = 0;
            for (int j = 1; j * i <= maxVal; j++) {
                int l = j * i, r = min((j + 1) * i - 1, maxVal);
                ans += (long long) (cnt[r] - cnt[l - 1]) * j % MOD;
                total += cnt[r] - cnt[l - 1];
            }
            ans += (long long) (n - total) * maxVal / i;
        }
        return ans % MOD;
    }
};