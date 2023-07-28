class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        vector<long long> a(n + 1);
        for (int i = 0; i < n; ++i) {
            a[i + 1] = a[i] + stations[i];
        }
        auto sum = [&](int l, int r) {
            return a[r + 1] - a[l];
        };
        auto check = [&](long long x) {
            long long need = 0;
            for (int i = 0, j = 0; i < n; i = j) {
                while (j < n && stations[j] <= x) {
                    ++j;
                }
                long long len = j - i;
                need += (len - 1) / (r * 2 + 1);
            }
            return need <= k;
        };
        long long l = 0, r = 1e10;
        while (l < r) {
            long long m = (l + r + 1) >> 1;
            if (check(m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
};