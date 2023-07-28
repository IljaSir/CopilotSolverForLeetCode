class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int mx = 0;
            for (int j = i; j < n; ++j) {
                mx = max(mx, s[j] - '0');
                if (mx > k) break;
                ans = max(ans, j - i + 1);
            }
        }
        return ans == n ? -1 : n - ans;
    }
};