class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        sort(packages.begin(), packages.end());
        for (auto& box : boxes) {
            sort(box.begin(), box.end());
        }
        int n = packages.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + packages[i];
        }
        long long ans = LLONG_MAX;
        for (auto& box : boxes) {
            if (box.back() < packages.back()) continue;
            int i = 0, j = 0;
            long long cur = 0;
            while (i < n && j < box.size()) {
                if (box[j] < packages[i]) {
                    ++j;
                } else {
                    cur += 1LL * (j + 1) * packages[i] - prefix[i + 1];
                    ++i;
                }
            }
            if (i == n) {
                ans = min(ans, cur);
            }
        }
        return ans == LLONG_MAX ? -1 : ans % (1000000007);
    }
};