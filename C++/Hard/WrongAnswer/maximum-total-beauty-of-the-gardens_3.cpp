class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        
        long long res = 0;
        int n = flowers.size();
        vector<int> cnt(target + 1);
        for (int i = 0; i < n; ++i) {
            if (flowers[i] > target) {
                res += full;
            } else {
                ++cnt[flowers[i]];
            }
        }
        long long sum = 0;
        for (int i = 1; i <= target; ++i) {
            sum += cnt[i] * i;
        }
        long long ans = res + (n - res / full) * partial;
        for (int i = 1; i <= target; ++i) {
            long long cur = res + (n - res / full) * partial;
            long long left = newFlowers;
            int j = 0;
            while (j < i) {
                long long need = (target - j) * cnt[j];
                if (need <= left) {
                    cur -= need * partial;
                    cur += need * full;
                    left -= need;
                } else {
                    cur -= left * partial;
                    cur += left * full;
                    left = 0;
                    break;
                }
                ++j;
            }
            if (left > 0) {
                if (left % target == 0) {
                    cur += left / target * full;
                } else {
                    cur += (left / target + 1) * full;
                }
            }
            ans = max(ans, cur);
        }
        return ans;
    }
};