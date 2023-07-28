class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        const int MOD = 1e9 + 7;
        int maxNum = *max_element(nums.begin(), nums.end());
        vector<int> cnt(maxNum + 1);
        for (int num: nums) {
            ++cnt[num];
        }
        for (int i = 1; i <= maxNum; ++i) {
            cnt[i] += cnt[i - 1];
        }
        long long ans = 0;
        for (int i = 1; i <= maxNum; ++i) {
            long long sum = 0;
            for (int j = i; j <= maxNum; j += i) {
                sum += (long long) (cnt[min(j + i - 1, maxNum)] - cnt[j - 1]) * j;
            }
            ans += sum * i;
        }
        return ans % MOD;
    }
};