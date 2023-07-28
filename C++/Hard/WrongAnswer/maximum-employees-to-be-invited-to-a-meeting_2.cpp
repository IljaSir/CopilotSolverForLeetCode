class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> f(n);
        for (int i = 0; i < n; ++i) {
            f[i] = favorite[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = i; j != -1; j = f[j]) {
                cnt++;
                f[j] = -1;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};