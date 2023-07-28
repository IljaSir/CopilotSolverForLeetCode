class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        int n = ranks.size();
        sort(ranks.begin(), ranks.end());
        long long l = 0, r = 1e18;
        while (l < r) {
            long long mid = l + (r-l) / 2;
            int c = 0;
            for (int i = 0; i < n; i++) {
                long long t = (long long)ranks[i] * ranks[i];
                c += mid / t;
            }
            if (c >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};