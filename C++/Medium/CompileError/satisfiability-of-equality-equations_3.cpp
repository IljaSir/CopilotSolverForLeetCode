class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26, -1);
        for (auto& e : equations) {
            if (e[1] == '=') {
                int x = e[0] - 'a';
                int y = e[3] - 'a';
                union_op(parent, x, y);
            }
        }
        for (auto& e : equations) {
            if (e[1] == '!') {
                int x = e[0] - 'a';
                int y = e[3] - 'a';
                if (find_op(parent, x) == find_op(parent, y))
                    return false;
            }
        }
        return true;
    }
    void union_op(vector<int>& parent, int x, int y) {
        int px = find_op(parent, x);
        int py = find_op(parent, y);
        if (px != py)
            parent[px] = py;
    }
};