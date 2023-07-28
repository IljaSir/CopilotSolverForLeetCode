class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        
        int n = dist.size();
        vector<int> times(n);
        for (int i = 0; i < n; i++) {
            times[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        sort(times.begin(), times.end());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] <= i) {
                return i;
            }
        }
        return n;
    }
};