class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.length();
        long long ans = 0;
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            mx = max(mx, s[i] - 'a');
            ans += mx;
        }
        return ans;
    }
};