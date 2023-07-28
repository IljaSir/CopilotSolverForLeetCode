class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        int n = security.size();
        vector<int> res;
        vector<int> pre(n, 0), suf(n, 0);
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                pre[i] = security[i];
            } else {
                pre[i] = max(pre[i - 1], security[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                suf[i] = security[i];
            } else {
                suf[i] = max(suf[i + 1], security[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i - time < 0 || i + time >= n) {
                continue;
            }
            if (pre[i - 1] <= security[i] && suf[i + 1] <= security[i]) {
                res.push_back(i);
            }
        }
        return res;
    }
};