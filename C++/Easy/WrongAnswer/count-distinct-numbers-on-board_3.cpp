class Solution {
public:
    int distinctIntegers(int n) {
        
        vector<bool> vis(n+1, false);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            res++;
            for (int j = i; j <= n; j += i) {
                vis[j] = true;
            }
        }
        return res;
    }
};