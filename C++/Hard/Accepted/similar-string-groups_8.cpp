class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        int g = n;
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            return p[x] == x ? x : p[x] = find(p[x]);
        };
        auto unite = [&](int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                g--;
            }
        };
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = 0;
                for (int k = 0; k < strs[i].size(); k++) {
                    if (strs[i][k] != strs[j][k]) {
                        diff++;
                    }
                }
                if (diff == 2 || diff == 0) {
                    unite(i, j);
                }
            }
        }
        return g;
    }
};