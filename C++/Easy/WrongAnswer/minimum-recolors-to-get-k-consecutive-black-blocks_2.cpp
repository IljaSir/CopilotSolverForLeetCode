class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> prefix(n+1, 0);
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + (blocks[i-1] == 'B');
        }
        int ans = INT_MAX;
        for(int i = 1; i <= n - k + 1; i++) {
            int cur = prefix[i + k - 1] - prefix[i - 1];
            int need = k - cur;
            int cost = need - (blocks[i-1] == 'B') - (blocks[i+k-1] == 'B');
            ans = min(ans, cost);
        }
        return ans;
    }
};