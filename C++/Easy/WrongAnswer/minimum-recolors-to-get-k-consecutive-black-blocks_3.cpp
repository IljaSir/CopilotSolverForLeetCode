class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> cnt(n+1);
        for(int i = 0; i < n; ++i) {
            cnt[i+1] = cnt[i] + (blocks[i] == 'B');
        }
        int res = INT_MAX;
        for(int i = 0; i + k <= n; ++i) {
            int j = i + k;
            int cur = cnt[j] - cnt[i];
            res = min(res, cur + (j - i - cur) / 2);
        }
        return res;
    }
};