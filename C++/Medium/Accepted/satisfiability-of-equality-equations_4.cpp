class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26, -1);
        for (auto& eq : equations) {
            if (eq[1] == '=') {
                int x = eq[0] - 'a';
                int y = eq[3] - 'a';
                int px = find(parent, x);
                int py = find(parent, y);
                if (px != py) {
                    parent[px] = py;
                }
            }
        }
        for (auto& eq : equations) {
            if (eq[1] == '!') {
                int x = eq[0] - 'a';
                int y = eq[3] - 'a';
                int px = find(parent, x);
                int py = find(parent, y);
                if (px == py) {
                    return false;
                }
            }
        }
        return true;
    }
    int find(vector<int>& parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
};