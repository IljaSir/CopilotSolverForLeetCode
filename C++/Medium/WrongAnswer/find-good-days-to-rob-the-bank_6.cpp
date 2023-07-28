class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        int n = security.size();
        vector<int> ans;
        vector<int> maxBefore(n), minAfter(n);
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                maxBefore[i] = security[i];
            } else {
                maxBefore[i] = max(maxBefore[i - 1], security[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                minAfter[i] = security[i];
            } else {
                minAfter[i] = min(minAfter[i + 1], security[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i - time >= 0 && i + time < n) {
                int left = maxBefore[i - time];
                int right = minAfter[i + time];
                if (left >= security[i] && right >= security[i]) {
                    ans.push_back(i);
                }
            }
        }
        return ans;
    }
};