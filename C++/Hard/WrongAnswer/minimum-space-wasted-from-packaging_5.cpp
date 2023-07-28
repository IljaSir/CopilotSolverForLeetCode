class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        sort(packages.begin(), packages.end());
        for (auto& box: boxes) {
            sort(box.begin(), box.end());
        }
        int n = packages.size();
        int m = boxes.size();
        long long prefix[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + packages[i - 1];
        }
        long long ans = LLONG_MAX;
        for (auto& box: boxes) {
            int j = 0;
            long long waste = 0;
            for (int k = 0; k < box.size(); ++k) {
                while (j < n && packages[j] <= box[k]) {
                    ++j;
                }
                waste += (long long) box[k] * (j - k - 1) - (prefix[j] - prefix[k + 1]);
            }
            if (j == n) {
                ans = min(ans, waste);
            }
        }
        return ans == LLONG_MAX ? -1 : ans % (int) (1e9 + 7);
    }
};