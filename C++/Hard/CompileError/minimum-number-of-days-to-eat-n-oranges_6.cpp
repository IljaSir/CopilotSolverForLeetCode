class Solution {
public:
    int minDays(int n) {
        
        unordered_map<int, int> cache;
        return dfs(n, cache);
    }
};