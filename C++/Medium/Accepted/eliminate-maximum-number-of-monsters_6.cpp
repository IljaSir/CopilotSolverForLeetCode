class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        
        int n = dist.size();
        vector<int> times(n, 0);
        for (int i = 0; i < n; ++i) {
            times[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        sort(times.begin(), times.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (ans < times[i]) {
                ++ans;
            } else {
                break;
            }
        }
        return ans;
    }
};