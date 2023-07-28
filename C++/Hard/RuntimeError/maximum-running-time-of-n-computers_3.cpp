class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        long long l = 0, r = 1e18;
        while (l < r) {
            long long m = l + (r - l + 1) / 2;
            int cnt = 0;
            for (int i = 0; i < batteries.size(); i++) {
                cnt += m / batteries[i];
            }
            if (cnt >= n) l = m;
            else r = m - 1;
        }
        return l;
    }
};