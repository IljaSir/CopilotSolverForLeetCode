class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        long long l = 0, r = 1e18, m;
        while (l < r) {
            m = (l + r + 1) >> 1;
            int cnt = 0;
            for (int i = 0; i < batteries.size(); i++) {
                cnt += m / batteries[i];
                if (cnt >= n) break;
            }
            if (cnt >= n) l = m;
            else r = m - 1;
        }
        return l;
    }
};