class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parents(n);
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        for (auto& connection : connections) {
            int p1 = find(parents, connection[0]);
            int p2 = find(parents, connection[1]);
            if (p1 != p2) {
                parents[p1] = p2;
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == i) {
                ++count;
            }
        }
        return count - 1;
    }
};