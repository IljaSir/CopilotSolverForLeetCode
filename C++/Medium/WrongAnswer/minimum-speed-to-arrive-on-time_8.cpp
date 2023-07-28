class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        
        int n = dist.size();
        int l = 1, r = 1e7;
        while(l < r) {
            int m = l + (r - l) / 2;
            double time = 0;
            for(int i = 0; i < n - 1; i++) {
                time += (dist[i] + m - 1) / m;
            }
            time += 1.0 * dist[n - 1] / m;
            if(time <= hour) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l == 1e7 ? -1 : l;
    }
};