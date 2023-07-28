class Solution {
public:
    int longestDecomposition(string text) {
        
        int n = text.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            string s1 = text.substr(0, i + 1);
            string s2 = text.substr(n - i - 1, i + 1);
            if (s1 == s2) {
                ans += 2;
                text = text.substr(i + 1, n - 2 * (i + 1));
                n -= 2 * (i + 1);
                i = -1;
            }
        }
        if (n != 0) ans++;
        return ans;
    }
};