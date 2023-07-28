class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        };
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (strs[i].size() != strs[j].size()) {
                    continue;
                }
                int diff = 0;
                for (int k = 0; k < strs[i].size(); ++k) {
                    if (strs[i][k] != strs[j][k]) {
                        ++diff;
                    }
                }
                if (diff == 2) {
                    p[find(i)] = find(j);
                }
            }
        }
        unordered_set<int> s;
        for (int i = 0; i < n; ++i) {
            s.insert(find(i));
        }
        return s.size();
    }
};