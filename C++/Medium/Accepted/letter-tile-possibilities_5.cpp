class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        int n = tiles.size();
        vector<int> count(26);
        for (char c : tiles) {
            count[c - 'A']++;
        }
        return dfs(count);
    }
    int dfs(vector<int> &count) {
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] == 0) {
                continue;
            }
            ans++;
            count[i]--;
            ans += dfs(count);
            count[i]++;
        }
        return ans;
    }
};