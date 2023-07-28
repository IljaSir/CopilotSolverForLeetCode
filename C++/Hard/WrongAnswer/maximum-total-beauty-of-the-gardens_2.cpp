class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        
        long long ans = 0;
        int n = flowers.size();
        vector<int> cnt(n + 1);
        for (int i = 0; i < n; ++i) {
            ++cnt[flowers[i]];
        }
        for (int i = 0; i < n; ++i) {
            if (flowers[i] < target) {
                int x = target - flowers[i];
                long long y = min(newFlowers, (long long)x * cnt[flowers[i]]);
                flowers[i] += y / cnt[flowers[i]];
                newFlowers -= y;
            }
        }
        int m = 0;
        for (int i = 0; i < n; ++i) {
            m = max(m, flowers[i]);
        }
        long long sum = 0;
        for (int i = 0; i < n; ++i) {
            if (flowers[i] < m) {
                sum += m - flowers[i];
            }
        }
        newFlowers -= sum;
        int c = 0;
        for (int i = 0; i < n; ++i) {
            if (flowers[i] >= m) {
                ++c;
            }
        }
        ans = (long long)c * full + min(newFlowers / c, (long long)m) * partial;
        return ans;
    }
};