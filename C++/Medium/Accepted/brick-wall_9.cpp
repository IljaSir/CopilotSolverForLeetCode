class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        unordered_map<int, int> h;
        int n = wall.size();
        for(int i = 0; i < n; i++) {
            int m = wall[i].size();
            int sum = 0;
            for(int j = 0; j < m - 1; j++) {
                sum += wall[i][j];
                h[sum]++;
            }
        }
        int ans = n;
        for(auto it = h.begin(); it != h.end(); it++) {
            ans = min(ans, n - it->second);
        }
        return ans;
    }
};