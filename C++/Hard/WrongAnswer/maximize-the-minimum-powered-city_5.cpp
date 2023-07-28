class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        sort(stations.begin(), stations.end());
        long long ans = 0;
        for (int i = 0; i < stations.size(); i++) {
            long long l = i > 0 ? stations[i - 1] : -1;
            long long r = i < stations.size() - 1 ? stations[i + 1] : 1e9;
            long long d = min(stations[i] - l, r - stations[i]);
            if (d > r) continue;
            long long c = (d + 1) * (d + 2) / 2;
            long long need = (r - d) * (r - d + 1) / 2 - c;
            if (need > k) {
                long long low = d + 1, high = r;
                while (low < high) {
                    long long mid = (low + high) / 2;
                    long long c = (mid + 1) * (mid + 2) / 2;
                    long long need = (mid - d) * (mid - d + 1) / 2 - c;
                    if (need <= k) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                ans = max(ans, d + low + 1);
                k -= (low - d) * (low - d + 1) / 2 - c;
            } else {
                ans = max(ans, r + 1);
                k -= need;
            }
        }
        return ans;
    }
};