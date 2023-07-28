class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        int s = 0;
        for (int i = 0; i < n - 1; ++i) {
            int d = stations[i + 1] - stations[i];
            if (d > 2 * r) {
                s += (d - 1) / (2 * r);
            }
        }
        long long l = 0, r = 1e18;
        while (l < r) {
            long long mid = l + (r - l + 1) / 2;
            long long cnt = 0;
            for (int i = 0; i < n - 1; ++i) {
                int d = stations[i + 1] - stations[i];
                if (d > 2 * r) {
                    cnt += (d - 1) / (2 * r) - 1;
                }
            }
            if (cnt <= 0) {
                l = mid,
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};