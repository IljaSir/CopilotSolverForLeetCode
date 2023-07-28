class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        int n = ranks.size();
        sort(ranks.begin(), ranks.end());
        long long ans = 1e18;
        for (int i = 0; i < n; i++) {
            long long cur = 0;
            int need = cars;
            for (int j = i; j < n; j++) {
                long long t = 1LL * ranks[j] * need * need;
                cur += t;
                need = (need + 1) / 2;
            }
            ans = min(ans, cur);
        }
        return ans;
    }
};