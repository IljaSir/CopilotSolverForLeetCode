class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        int l = 0, r = 1e9;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(stations, m, r, k)) l = m;
            else r = m - 1;
        }
        return l;
    }
    
    bool check(vector<int>& stations, int m, int r, int k) {
        int cnt = 0;
        for (int i = 1; i < stations.size(); ++i) {
            int d = stations[i] - stations[i - 1];
            if (d > 2 * r) {
                cnt += (d - 2 * r + 2 * r - 1) / (2 * r);
            }
        }
        return cnt <= k;
    }
};