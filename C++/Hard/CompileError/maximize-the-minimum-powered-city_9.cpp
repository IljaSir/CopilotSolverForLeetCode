class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        if (n == 0) return 0;
        if (n == 1) return stations[0] + k;
        int nStations = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nStations += stations[i] / (r + 1);
                if (stations[i] % (r + 1) != 0) nStations++;
            } else {
                int d = stations[i] - stations[i - 1];
                nStations += (d - 2 * r - 1) / (r + 1);
                if ((d - 2 * r - 1) % (r + 1) != 0) nStations++;
            }
        }
        int left = 0, right = 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int nStations2 = nStations + mid;
            int nCities = 0;
            for (int i = 0; i < n; i++) {
                int l = stations[i] - r;
                int r = stations[i] + r;
                if (i == 0) {
                    nCities += (r - l) / (r + 1);
                    if ((r - l) % (r + 1) != 0) nCities++;
                } else {
                    int l2 = stations[i - 1] - r;
                    int r2 = stations[i - 1] + r;
                    if (l2 > r) {
                        nCities += (r - l) / (r + 1);
                        if ((r - l) % (r + 1) != 0) nCities++;
                    } else {
                        int d = min(r, r2) - max(l, l2);
                        if (d < 0) d = 0;
                        nCities += (r - l - d) / (r + 1);
                        if ((r - l - d) % (r + 1) != 0) nCities++;
                    }
                }
            }
            if (nCities >= nStations2) right = mid;
            else left = mid +
    }
};