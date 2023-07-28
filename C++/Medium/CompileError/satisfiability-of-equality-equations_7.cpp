class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26, -1);
        for (auto& e: equations) {
            if (e[1] == '!') continue;
            int x = e[0] - 'a';
            int y = e[3] - 'a';
            parent[findParent(parent, x)] = findParent(parent, y);
        }
        for (auto& e: equations) {
            if (e[1] == '=') continue;
            int x = e[0] - 'a';
            int y = e[3] - 'a';
            if (findParent(parent, x) == findParent(parent, y)) return false;
        }
        return true;
    }
};