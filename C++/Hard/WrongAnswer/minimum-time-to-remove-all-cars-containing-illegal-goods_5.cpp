class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ans += 2;
            }
        }
        ans -= 2;
        return max(ans, 0);
    }
};