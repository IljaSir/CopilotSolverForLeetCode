class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        int n = wall.size();
        int m = 0;
        for(int i = 0; i < n; i++) {
            m = max(m, (int)wall[i].size());
        }
        unordered_map<int, int> um;
        for(int i = 0; i < n; i++) {
            int s = 0;
            for(int j = 0; j < m; j++) {
                if(j < wall[i].size()) {
                    s += wall[i][j];
                    um[s]++;
                }
            }
        }
        int ans = n;
        for(auto it = um.begin(); it != um.end(); it++) {
            if(it->first != 0) {
                ans = min(ans, n - it->second);
            }
        }
        return ans;
    }
};