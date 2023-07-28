class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        unordered_map<char, int> count;
        for (char c : tiles) {
            count[c]++;
        }
        return dfs(count);
    }
    
    int dfs(unordered_map<char, int> count) {
        int res = 0;
        for (auto& [c, n] : count) {
            if (n == 0) {
                continue;
            }
            res++;
            count[c]--;
            res += dfs(count);
            count[c]++;
        }
        return res;
    }
};