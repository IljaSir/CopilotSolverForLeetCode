class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        int n = dist.size();
        int l = 1, r = 1e7;
        while (l < r) {
            int mid = (l + r) / 2;
            double time = 0;
            for (int i = 0; i < n - 1; i++) {
                time += ceil(dist[i] * 1.0 / mid);
            }
            time += dist[n - 1] * 1.0 / mid;
            if (time <= hour) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > 1e7 ? -1 : l;
    }
};