class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        map<int, int> cnt;
        for (int b : beans) cnt[b]++;
        vector<int> values;
        for (auto& kv : cnt) values.push_back(kv.first);
        int n = values.size();
        vector<long long> sum(n + 1);
        for (int i = 0; i < n; ++i) sum[i + 1] = sum[i] + values[i];
        long long res = 1e18;
        for (int i = 0; i < n; ++i) {
            long long need = 1LL * (i + 1) * values[i] - sum[i + 1];
            long long extra = sum[n] - sum[i + 1] - 1LL * (n - i - 1) * values[i];
            res = min(res, need + extra);
        }
        return res;
    }
};