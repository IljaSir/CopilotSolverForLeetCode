class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> b(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            b[i] = b[i - 1] + (blocks[i - 1] == 'B');
        }
        vector<int> f(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            int l = max(1, i - k + 1), r = i;
            f[i] = f[i - 1] + (blocks[i - 1] == 'W');
            if (r - l + 1 >= k) {
                f[i] = min(f[i], f[l - 1] + (b[r] - b[l - 1] == 0));
            }
        }
        return f[n];
    }
};