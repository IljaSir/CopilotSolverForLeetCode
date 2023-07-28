class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        int res = 0;
        for (auto& e : edges) {
            if (e[0] == 3) {
                if (find(parent, e[1]) != find(parent, e[2])) {
                    parent[find(parent, e[1])] = find(parent, e[2]);
                    --n;
                } else {
                    ++res;
                }
            }
        }
        vector<int> parentA = parent;
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (find(parentA, e[1]) != find(parentA, e[2])) {
                    parentA[find(parentA, e[1])] = find(parentA, e[2]);
                    --n;
                } else {
                    ++res;
                }
            }
        }
        vector<int> parentB = parent;
        for (auto& e : edges) {
            if (e[0] == 2) {
                if (find(parentB, e[1]) != find(parentB, e[2])) {
                    parentB[find(parentB, e[1])] = find(parentB, e[2]);
                    --n;
                } else {
                    ++res;
                }
            }
        }
        return n == 1 ? res : -1;
    }
};