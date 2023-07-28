class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        
        vector<bool> result;
        vector<int> parent(n + 1, 0);
        for (int i = 1; i <= n; ++i) parent[i] = i;
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = i + i; j <= n; j += i) {
                int p1 = find(parent, i);
                int p2 = find(parent, j);
                if (p1 != p2) parent[p1] = p2;
            }
        }
        for (auto& q : queries) {
            result.push_back(find(parent, q[0]) == find(parent, q[1]));
        }
        return result;
    }
};