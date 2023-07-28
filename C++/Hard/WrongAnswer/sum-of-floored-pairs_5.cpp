class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int n = nums.size();
        int max = *max_element(nums.begin(), nums.end());
        vector<int> cnt(max + 1, 0);
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= max; i++) {
            cnt[i] += cnt[i - 1];
        }
        int res = 0;
        int mod = 1000000007;
        for (int i = 1; i <= max; i++) {
            if (cnt[i] == n) {
                break;
            }
            int sum = 0;
            for (int j = 1; j * i <= max; j++) {
                int l = (j - 1) * i + 1;
                int r = j * i;
                sum = (sum + (long long)(cnt[r] - cnt[l - 1]) * j) % mod;
            }
            res = (res + (long long)(n - cnt[i]) * sum) % mod;
        }
        return res;
    }
};