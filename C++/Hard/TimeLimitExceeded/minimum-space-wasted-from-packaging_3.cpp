class Solution {
public:
    int minWastedSpace(vector<int>& packages, vector<vector<int>>& boxes) {
        
        sort(packages.begin(), packages.end());
        int n = packages.size();
        int m = boxes.size();
        int mod = 1e9 + 7;
        long long res = INT_MAX;
        for (int i = 0; i < m; i++) {
            sort(boxes[i].begin(), boxes[i].end());
            if (boxes[i].back() < packages.back()) continue;
            long long waste = 0;
            int j = 0;
            for (int k = 0; k < boxes[i].size(); k++) {
                while (j < n && packages[j] <= boxes[i][k]) {
                    waste += boxes[i][k] - packages[j];
                    j++;
                }
            }
            res = min(res, waste);
        }
        return res == INT_MAX ? -1 : res % mod;
    }
};