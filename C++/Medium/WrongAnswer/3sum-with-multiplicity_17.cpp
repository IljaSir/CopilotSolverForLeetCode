class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int mod = 1e9 + 7;
        int n = arr.size();
        vector<int> cnt(101, 0);
        for (int x : arr) {
            cnt[x]++;
        }
        long long ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    ans += (long long)cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if (i == j && j < k) {
                    ans += (long long)cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                } else if (j < k) {
                    ans += (long long)cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        return ans % mod;
    }
};