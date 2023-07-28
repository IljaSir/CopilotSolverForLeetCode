class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        int n = dist.size();
        if (hour <= n - 1) return -1;
        int l = 1, r = 1e7;
        while (l < r) {
            int m = l + (r - l) / 2;
            double sum = 0;
            for (int i = 0; i < n - 1; ++i) {
                sum += (dist[i] + m - 1) / m;
            }
            sum += (double)dist.back() / m;
            if (sum <= hour) r = m;
            else l = m + 1;
        }
        return l;
    }
};