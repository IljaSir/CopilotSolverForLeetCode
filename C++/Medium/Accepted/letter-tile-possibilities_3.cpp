class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        vector<int> cnt(26, 0);
        for (char c : tiles) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }
    int dfs(vector<int>& cnt) {
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] == 0) {
                continue;
            }
            ++ans;
            --cnt[i];
            ans += dfs(cnt);
            ++cnt[i];
        }
        return ans;
    }
};