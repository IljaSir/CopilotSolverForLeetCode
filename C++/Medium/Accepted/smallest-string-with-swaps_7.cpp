class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.length();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        for (auto p : pairs) {
            int a = find(parent, p[0]);
            int b = find(parent, p[1]);
            parent[a] = b;
        }
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            m[p].push_back(i);
        }
        for (auto it : m) {
            auto it2 = it.second;
            string sub;
            for (int i : it2) {
                sub.push_back(s[i]);
            }
            sort(sub.begin(), sub.end());
            int i = 0;
            for (int j : it2) {
                s[j] = sub[i++];
            }
        }
        return s;
    }
    int find(vector<int> &parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};