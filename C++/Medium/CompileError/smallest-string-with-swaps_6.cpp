class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<int> parent(n);
        vector<int> size(n, 1);
        for (int i = 0; i < n; i++) parent[i] = i;
        for (auto& p : pairs) {
            int x = find(parent, p[0]);
            int y = find(parent, p[1]);
            if (x == y) continue;
            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
        }
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            m[p].push_back(i);
        }
        for (auto& [p, v] : m) {
            vector<char> t;
            for (auto& i : v) t.push_back(s[i]);
            sort(t.begin(), t.end());
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size(); i++) s[v[i]] = t[i];
        }
        return s;
    }
};