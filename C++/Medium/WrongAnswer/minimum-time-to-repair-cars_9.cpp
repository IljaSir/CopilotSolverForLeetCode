class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        auto check = [&](long long t) {
            long long tmp = 0;
            for (int r : ranks) {
                long long n = r;
                tmp += t / (n * n);
            }
            return tmp >= cars;
        };
        long long l = 0, r = 1e18;
        while (l < r) {
            long long m = l + (r - l) / 2;
            if (check(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
};