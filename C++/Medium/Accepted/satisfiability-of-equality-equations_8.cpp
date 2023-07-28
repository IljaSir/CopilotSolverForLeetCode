class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        int n = equations.size();
        vector<int> parent(26);
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (auto &e: equations) {
            if (e[1] == '=') {
                int x = e[0] - 'a';
                int y = e[3] - 'a';
                parent[find(parent, x)] = find(parent, y);
            }
        }
        for (auto &e: equations) {
            if (e[1] == '!') {
                int x = e[0] - 'a';
                int y = e[3] - 'a';
                if (find(parent, x) == find(parent, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    int find(vector<int> &parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};