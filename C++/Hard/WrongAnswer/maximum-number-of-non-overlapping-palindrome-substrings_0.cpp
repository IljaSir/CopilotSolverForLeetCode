class Solution {
public:
    int maxPalindromes(string s, int k) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s[l] == s[r]) {
                if (r - l + 1 >= k) {
                    ans++;
                }
                l--;
                r++;
            }
            l = i, r = i + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                if (r - l + 1 >= k) {
                    ans++;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
};