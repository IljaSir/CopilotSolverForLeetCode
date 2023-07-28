class Solution {
public:
    int countSubstrings(string s) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n; j++) {
                if (s[i - j] != s[i + j]) {
                    break;
                }
                ans++;
            }
            for (int j = 0; i - j >= 0 && i + j + 1 < n; j++) {
                if (s[i - j] != s[i + j + 1]) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }
};