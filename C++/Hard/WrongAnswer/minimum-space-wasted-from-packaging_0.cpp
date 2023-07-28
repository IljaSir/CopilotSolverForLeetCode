class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        sort(packages.begin(), packages.end());
        int n = packages.size();
        long long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += packages[i];
        }
        long long ans = LLONG_MAX;
        for (auto& b : boxes) {
            sort(b.begin(), b.end());
            if (b.back() < packages.back()) {
                continue;
            }
            int j = 0;
            long long cur = 0;
            for (int i = 0; i < b.size(); ++i) {
                while (j < n && packages[j] <= b[i]) {
                    ++j;
                }
                cur += (long long)b[i] * (j - i);
            }
            ans = min(ans, cur);
        }
        return ans == LLONG_MAX ? -1 : (ans - sum) % 1000000007;
    }
};