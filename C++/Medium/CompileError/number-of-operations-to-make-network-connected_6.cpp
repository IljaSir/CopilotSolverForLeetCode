class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n);
        for (int i = 0; i < n; i++) parent[i] = i;
        int cnt = n;
        for (auto& c : connections) {
            int x = find(parent, c[0]);
            int y = find(parent, c[1]);
            if (x != y) {
                parent[y] = x;
                cnt--;
            }
        }
        return cnt - 1;
    }
};