class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        int n = security.size();
        vector<int> prefix(n, 0);
        vector<int> suffix(n, 0);
        prefix[0] = security[0];
        suffix[n - 1] = security[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = max(prefix[i - 1], security[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = max(suffix[i + 1], security[i]);
        }
        vector<int> result;
        for (int i = 0; i < n; i++) {
            if (i - time >= 0 && i + time < n && prefix[i - time] <= security[i] && security[i] <= suffix[i + time]) {
                result.push_back(i);
            }
        }
        return result;
    }
};