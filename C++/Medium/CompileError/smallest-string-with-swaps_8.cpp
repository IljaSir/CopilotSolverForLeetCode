class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        
        int n = s.size();
        vector<int> parent(n, -1);
        for (auto& p: pairs) {
            int p1 = find(parent, p[0]);
            int p2 = find(parent, p[1]);
            if (p1 != p2) {
                parent[p2] = p1;
            }
        }
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            m[p].push_back(i);
        }
        for (auto& [p, v]: m) {
            sort(v.begin(), v.end(), [&](int i, int j) { return s[i] < s[j]; });
        }
        string res(n, ' ');
        for (int i = 0; i < n; ++i) {
            int p = find(parent, i);
            res[i] = s[m[p].back()];
            m[p].pop_back();
        }
        return res;
    }
};