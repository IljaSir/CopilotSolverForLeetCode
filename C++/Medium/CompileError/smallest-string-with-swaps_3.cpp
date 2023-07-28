class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (auto& p : pairs) {
            int x = find(parent, p[0]);
            int y = find(parent, p[1]);
            parent[x] = y;
        }
        unordered_map<int, vector<int>> group;
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            group[p].push_back(i);
        }
        for (auto& [p, v] : group) {
            sort(v.begin(), v.end());
            vector<char> chars;
            for (int i : v) {
                chars.push_back(s[i]);
            }
            sort(chars.begin(), chars.end());
            for (int i = 0; i < v.size(); ++i) {
                s[v[i]] = chars[i];
            }
        }
        return s;
    }
};