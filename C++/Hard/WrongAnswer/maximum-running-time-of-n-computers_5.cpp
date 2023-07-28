class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        
        sort(batteries.begin(), batteries.end());
        int l = 0, r = batteries.size() - n;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(n, batteries, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return batteries[l];
    }
    bool check(int n, vector<int>& batteries, int m) {
        long long sum = 0;
        for (int i = m; i < m + n; i++) {
            sum += batteries[i];
        }
        for (int i = m + n; i < batteries.size(); i++) {
            sum += batteries[i];
            sum -= batteries[i - n];
            if (sum < batteries[i]) {
                return false;
            }
        }
        return true;
    }
};