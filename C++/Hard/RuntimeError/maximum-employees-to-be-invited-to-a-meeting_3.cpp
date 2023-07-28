class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> next(n, -1);
        vector<int> visited(n, 0);
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            int j = i;
            while (next[j] == -1) {
                visited[j] = 1;
                next[j] = favorite[j];
                j = favorite[j];
            }
            if (next[j] != i) {
                int k = j;
                while (next[k] != j) {
                    next[k] = -1;
                    k = next[k];
                }
                next[k] = -1;
            }
        }
        return count(next.begin(), next.end(), -1);
    }
};