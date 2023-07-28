class Solution {
public:
    int numSub(string s) {
        
        int n = s.size();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '0') {
                cnt = 0;
                continue;
            }
            ans = (ans + (++cnt)) % 1000000007;
        }
        return ans;
    }
};