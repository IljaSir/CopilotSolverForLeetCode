class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        int n = dist.size();
        int l = 1, r = 1e7;
        while (l < r) {
            int mid = (l + r) / 2;
            double t = 0;
            for (int i = 0; i < n - 1; i++) {
                t += ceil(dist[i] * 1.0 / mid);
            }
            t += (dist[n - 1] * 1.0 / mid);
            if (t > hour) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r == 1e7 ? -1 : r;
    }
};