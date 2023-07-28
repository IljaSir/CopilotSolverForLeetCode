class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        
        vector<int> parent(26);
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (string &equation : equations) {
            if (equation[1] == '=') {
                int x = equation[0] - 'a';
                int y = equation[3] - 'a';
                unionSet(parent, x, y);
            }
        }
        for (string &equation : equations) {
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
    void unionSet(vector<int> &parent, int index1, int index2) {
        parent[findSet(parent, index1)] = findSet(parent, index2);
    }
    int findSet(vector<int> &parent, int index) {
        if (parent[index] != index) {
            parent[index] = findSet(parent, parent[index]);
        }
        return parent[index];
    }
};