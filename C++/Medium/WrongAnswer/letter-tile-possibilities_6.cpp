class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        int n = tiles.size();
        int ans = 0;
        vector<int> cnt(26, 0);
        for (char c : tiles) {
            cnt[c - 'A']++;
        }
        function<void(int)> dfs = [&](int i) {
            if (i == 26) return;
            for (int j = 1; j <= cnt[i]; j++) {
                ans++;
                cnt[i] -= j;
                dfs(i + 1);
                cnt[i] += j;
            }
            dfs(i + 1);
        };
        dfs(0);
        return ans;
    }
};