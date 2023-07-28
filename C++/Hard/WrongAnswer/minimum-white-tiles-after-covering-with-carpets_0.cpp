class Solution {
public:
    int minimumWhiteTiles(string floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        vector<int> dp(n + 1, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (floor[i] == '1') {
                ans++;
            }
            dp[i + 1] = dp[i] + (floor[i] == '1' ? 1 : -1);
        }
        int m = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (dp[mid + 1] - dp[i] <= numCarpets * carpetLen) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            m = max(m, l - i);
        }
        return ans - m;
    }
};