class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        sort(ranks.begin(), ranks.end());
        long long left = 1, right = 1e12;
        while (left < right) {
            long long mid = (left + right) >> 1;
            long long cnt = 0;
            for (int i = 0; i < ranks.size(); i++) {
                cnt += mid / (ranks[i] * ranks[i]);
            }
            if (cnt >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};