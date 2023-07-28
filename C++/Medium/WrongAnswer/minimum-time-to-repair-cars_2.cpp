class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        long long l = 0, r = 1e18;
        while (l < r) {
            long long m = (l + r) >> 1;
            long long cnt = 0;
            for (int r: ranks) {
                cnt += (m / (r * r));
            }
            if (cnt >= cars) r = m;
            else l = m + 1;
        }
        return l;
    }
};