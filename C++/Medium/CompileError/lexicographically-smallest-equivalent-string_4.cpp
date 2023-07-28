class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
        int n = s1.size();
        vector<int> parent(26);
        iota(parent.begin(), parent.end(), 0);
        for (int i = 0; i < n; ++i) {
            int x = s1[i] - 'a', y = s2[i] - 'a';
            int px = find(parent, x), py = find(parent, y);
            if (px < py) parent[py] = px;
            else parent[px] = py;
        }
        for (auto& c : baseStr) {
            c = 'a' + find(parent, c - 'a');
        }
        return baseStr;
    }
};