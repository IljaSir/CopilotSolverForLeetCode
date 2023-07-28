class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        sort(ranks.begin(), ranks.end());
        long long sum = 0;
        for (int i = 0; i < ranks.size(); i++) {
            sum += ranks[i];
            ranks[i] = sum;
        }
        long long l = 0, r = 1e18;
        while (l < r) {
            long long mid = l + r >> 1;
            long long cnt = 0;
            for (int i = 0; i < ranks.size(); i++) {
                long long n = sqrt(mid / ranks[i]);
                cnt += n;
            }
            if (cnt >= cars) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};