class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        
        int n = dist.size();
        double time[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) dist[i] / speed[i];
        }
        sort(time, time + n);
        int kill = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > i) {
                kill++;
            } else {
                break;
            }
        }
        return kill;
    }
};