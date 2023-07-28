class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p1] = p2;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return n - cnt;
    }
    
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};