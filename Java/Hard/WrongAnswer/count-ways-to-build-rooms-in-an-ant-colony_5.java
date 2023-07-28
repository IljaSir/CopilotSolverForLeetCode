class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int n = prevRoom.length;
        int mod = 1000000007;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; ++i) {
            int cnt = 0;
            for (int j = 0; j < i; ++j) {
                if (prevRoom[j] == i) {
                    ++cnt;
                }
            }
            int[] g = new int[cnt + 1];
            g[0] = 1;
            for (int j = 1; j <= cnt; ++j) {
                g[j] = (int) ((long) g[j - 1] * (i - j + 1) % mod);
            }
            f[i] = (int) ((long) f[prevRoom[i]] * g[cnt] % mod);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + f[i]) % mod;
        }
        return ans;
    }
}