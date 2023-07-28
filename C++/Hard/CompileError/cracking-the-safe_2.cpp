class Solution {
public:
    string crackSafe(int n, int k) {
        
        int total = pow(k, n);
        string password(n, '0');
        unordered_set<string> visited;
        visited.insert(password);
        dfs(password, visited, total, n, k);
        return password;
    }
};