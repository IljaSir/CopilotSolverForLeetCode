class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1);
        iota(parent.begin(), parent.end(), 0);
        int res = 0;
        for (auto& e : edges)
            if (e[0] == 3) {
                if (!unionSet(e[1], e[2], parent))
                    res++;
            }
        vector<int> a = parent, b = parent;
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (!unionSet(e[1], e[2], a))
                    res++;
            } else if (e[0] == 2) {
                if (!unionSet(e[1], e[2], b))
                    res++;
            }
        }
        for (int i = 1; i <= n; i++)
            if (find(i, a) != find(i, b))
                return -1;
        return res;
    }
    
    int find(int x, vector<int>& parent) {
        return parent[x] == x ? x : parent[x] = find(parent[x], parent);
    }
};