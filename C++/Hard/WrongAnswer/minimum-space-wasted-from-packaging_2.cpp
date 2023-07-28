class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        const int MOD = 1e9 + 7;
        sort(begin(packages), end(packages));
        for (auto& box: boxes)
            sort(begin(box), end(box));
        long long ans = numeric_limits<long long>::max();
        for (auto& box: boxes) {
            if (box.back() < packages.back()) continue;
            auto it = upper_bound(begin(box), end(box), packages.back());
            long long waste = 0;
            for (int i = 0, j = 0; i < packages.size(); ++i) {
                while (j < box.size() && box[j] < packages[i])
                    ++j;
                if (j == box.size()) break;
                waste += box[j++] - packages[i];
            }
            if (waste < ans) ans = waste;
        }
        return ans == numeric_limits<long long>::max() ? -1 : ans % MOD;
    }
};