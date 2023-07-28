class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        const int MOD = 1e9 + 7;
        int n = packages.size(), m = boxes.size();
        sort(packages.begin(), packages.end());
        int total = 0;
        for (auto& b : boxes) {
            sort(b.begin(), b.end());
            if (b.back() >= packages.back()) {
                int i = 0;
                for (auto& p : packages) {
                    while (i + 1 < b.size() && b[i + 1] <= p) ++i;
                    total += b[i] - p;
                    if (total >= MOD) total -= MOD;
                }
            }
        }
        return total == 0 ? -1 : total;
    }
};