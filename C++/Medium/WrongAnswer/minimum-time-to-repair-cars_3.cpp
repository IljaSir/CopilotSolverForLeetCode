class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        long long l = 0, r = 1e18;
        while (l < r) {
            long long mid = (l + r) / 2;
            long long cnt = 0;
            for (int i = 0; i < ranks.size(); i++) {
                cnt += mid / (ranks[i] * ranks[i]);
            }
            if (cnt >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};