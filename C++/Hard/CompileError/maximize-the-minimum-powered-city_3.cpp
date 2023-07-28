class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        long long l = 0, r = 1e16;
        while (l < r) {
            long long m = (l + r + 1) / 2;
            if (check(stations, m, r, k))
                l = m;
            else
                r = m - 1;
        }
        return l;
    }
    bool check(vector<int>& stations, long long m, int r, int k) {
        int cnt = 0;
        for (int i = 0; i < stations.size(); ++i) {
            int j = i;
            while (j < stations.size() && stations[j] <= stations[i] + 2 * r) ++j;
            cnt += (j - i - 1) / (r * 2 + 1);
            i = j - 1;
        }
        return cnt <= k;
    }
};