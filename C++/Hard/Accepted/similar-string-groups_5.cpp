class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        auto unite = [&](int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) parent[x] = y;
        };
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int diff = 0;
                for (int k = 0; k < strs[i].size(); ++k) {
                    if (strs[i][k] != strs[j][k]) {
                        ++diff;
                        if (diff > 2) break;
                    }
                }
                if (diff <= 2) unite(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) ++ans;
        }
        return ans;
    }
};