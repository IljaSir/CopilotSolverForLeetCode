class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        int s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 += (i % 2 == 0) ^ (s[i] - '0');
            s2 += (i % 2 == 1) ^ (s[i] - '0');
        }
        int ans = min(s1, s2);
        for (int i = 0; i < n; i++) {
            s1 += (s[i] - '0') ^ (s[(i + n / 2) % n] - '0');
            s2 += (s[i] - '0') ^ (s[(i + 1 + n / 2) % n] - '0');
            ans = min(ans, min(s1, s2));
        }
        return ans;
    }
};