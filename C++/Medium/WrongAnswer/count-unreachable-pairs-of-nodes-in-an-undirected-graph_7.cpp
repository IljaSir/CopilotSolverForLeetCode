class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n, -1);
        int count = n;
        for (auto& e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
            if (x != y) {
                parent[x] = y;
                --count;
            }
        }
        return (long long)count * (count - 1) / 2;
    }
    int find(vector<int>& parent, int x) {
        int root = x;
        while (parent[root] != -1) {
            root = parent[root];
        }
        while (parent[x] != -1) {
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }
        return root;
    }
};