class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        int parent[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (auto equation : equations) {
            if (equation[1] == '=') {
                int x = equation[0] - 'a';
                int y = equation[3] - 'a';
                unionSet(parent, x, y);
            }
        }
        for (auto equation : equations) {
            if (equation[1] == '!') {
                int x = equation[0] - 'a';
                int y = equation[3] - 'a';
                if (findSet(parent, x) == findSet(parent, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    int findSet(int parent[], int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent, parent[x]);
        }
        return parent[x];
    }
    void unionSet(int parent[], int x, int y) {
        int xset = findSet(parent, x);
        int yset = findSet(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }
};