class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i <= n; ++i) {
            if (!m.count(sum[i])) {
                m[sum[i]] = i;
            }
            if (m.count(sum[i] - 1)) {
                res = max(res, i - m[sum[i] - 1]);
            }
        }
        return res;
    }
};