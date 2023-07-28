class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        int n = dist.size();
        if (n-1 > hour) return -1;
        int l = 1, r = 1e7;
        while (l < r) {
            int m = (l+r)/2;
            double t = 0;
            for (int i = 0; i < n-1; i++) {
                t += ceil(dist[i]*1.0/m);
            }
            t += dist[n-1]*1.0/m;
            if (t <= hour) r = m;
            else l = m+1;
        }
        return l;
    }
};