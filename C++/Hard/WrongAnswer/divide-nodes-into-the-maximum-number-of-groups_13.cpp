class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n, 0);
        for(int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for(auto& e : edges) {
            int x = e[0]-1, y = e[1]-1;
            int px = find(parent, x), py = find(parent, y);
            if(px != py) {
                parent[px] = py;
            }
        }
        vector<int> count(n, 0);
        for(int i = 0; i < n; ++i) {
            int p = find(parent, i);
            count[p]++;
        }
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            if(count[i] > 0) {
                ans = max(ans, count[i]);
            }
        }
        return ans;
    }
    int find(vector<int>& parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};