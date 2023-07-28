class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n+1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (auto& e : edges) {
            if (e[0] == 3) {
                if (find(parent, e[1]) != find(parent, e[2])) {
                    n--;
                    parent[find(parent, e[1])] = find(parent, e[2]);
                } else {
                    res++;
                }
            }
        }
        int a = n, b = n;
        vector<int> parentA = parent, parentB = parent;
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (find(parentA, e[1]) != find(parentA, e[2])) {
                    a--;
                    parentA[find(parentA, e[1])] = find(parentA, e[2]);
                } else {
                    res++;
                }
            } else if (e[0] == 2) {
                if (find(parentB, e[1]) != find(parentB, e[2])) {
                    b--;
                    parentB[find(parentB, e[1])] = find(parentB, e[2]);
                } else {
                    res++;
                }
            }
        }
        if (a != 1 || b != 1) return -1;
        return res;
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};