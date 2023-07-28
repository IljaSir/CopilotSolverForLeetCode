class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> sum(n+1, 0);
        for(int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + (blocks[i-1] == 'B');
        }
        int ans = INT_MAX;
        for(int i = 0; i <= n-k; ++i) {
            int cur = sum[i+k] - sum[i];
            ans = min(ans, cur);
        }
        return k - ans;
    }
};