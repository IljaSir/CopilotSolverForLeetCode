class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> visited(n, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int cnt = 0;
                int cur = i;
                while (visited[cur] == 0) {
                    cnt++;
                    visited[cur] = cnt;
                    cur = favorite[cur];
                }
                if (visited[cur] > 0) {
                    cnt -= visited[cur] - 1;
                }
                ans += cnt;
            }
        }
        return ans;
    }
};