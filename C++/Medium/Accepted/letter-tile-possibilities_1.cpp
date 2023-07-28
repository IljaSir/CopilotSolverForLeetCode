class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        int n = tiles.length();
        vector<int> count(26, 0);
        for (int i = 0; i < n; i++) {
            count[tiles[i] - 'A']++;
        }
        return dfs(count);
    }
    
    int dfs(vector<int> &count) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            res++;
            count[i]--;
            res += dfs(count);
            count[i]++;
        }
        return res;
    }
};