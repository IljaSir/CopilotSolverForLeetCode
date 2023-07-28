class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26, -1);
        for (auto& e : equations) {
            if (e[1] == '!') continue;
            int x = e[0] - 'a', y = e[3] - 'a';
            int px = find(parent, x), py = find(parent, y);
            if (px != py) parent[px] = py;
        }
        for (auto& e : equations) {
            if (e[1] == '=') continue;
            int x = e[0] - 'a', y = e[3] - 'a';
            int px = find(parent, x), py = find(parent, y);
            if (px == py) return false;
        }
        return true;
    }
};