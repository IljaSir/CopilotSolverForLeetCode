class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        vector<int> gaps;
        for (int i = 1; i < n; i++) {
            gaps.push_back(stations[i] - stations[i - 1] - 1);
        }
        long long ans = 0;
        int l = 0, r = 2e5;
        while (l <= r) {
            int m = (l + r) / 2;
            if (check(gaps, m, r, k)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    
    bool check(vector<int>& gaps, long long m, int r, int k) {
        int cnt = 0;
        for (int gap : gaps) {
            cnt += (gap + r) / (2 * r + 1);
        }
        return cnt <= k;
    }
};