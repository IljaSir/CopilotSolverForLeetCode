class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.size();
        long long ans = 0;
        int mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            mx = max(mx, 0);
            if (s[i] == s[n - 1]) {
                ++mx;
            }
            ans += mx;
        }
        return ans;
    }
};