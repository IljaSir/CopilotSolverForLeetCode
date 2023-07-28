class Solution {
public:
    int checkWays(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        vector<int> parent(501, 0);
        for (auto& p : pairs) {
            parent[p[1]] = p[0];
        }
        vector<int> cnt(501, 0);
        for (auto& p : pairs) {
            int node = p[1];
            while (node != 0) {
                cnt[node]++;
                node = parent[node];
            }
        }
        int res = 0;
        for (int i = 1; i <= 500; i++) {
            if (cnt[i] == 1) {
                res++;
            }
        }
        if (res == 0) {
            return 0;
        }
        if (res == 1) {
            return 1;
        }
        return 2;
    }
};