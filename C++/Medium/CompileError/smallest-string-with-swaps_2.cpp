class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<int> parent(n);
        vector<int> size(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (auto& p : pairs) {
            int a = find(parent, p[0]);
            int b = find(parent, p[1]);
            if (a != b) {
                if (size[a] < size[b]) {
                    parent[a] = b;
                    size[b] += size[a];
                } else {
                    parent[b] = a;
                    size[a] += size[b];
                }
            }
        }
        unordered_map<int, vector<int>> groups;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groups[root].push_back(i);
        }
        for (auto& g : groups) {
            string str;
            for (int i : g.second) {
                str += s[i];
            }
            sort(str.begin(), str.end());
            for (int i = 0; i < g.second.size(); i++) {
                s[g.second[i]] = str[i];
            }
        }
        return s;
    }
};