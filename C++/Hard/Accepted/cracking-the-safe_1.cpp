class Solution {
public:
    string crackSafe(int n, int k) {
        
        string res(n, '0');
        if (n == 1) {
            for (int i = 1; i < k; ++i) {
                res += to_string(i);
            }
            return res;
        }
        int total = pow(k, n);
        unordered_set<string> visited;
        visited.insert(res);
        dfs(res, total, visited, k, n);
        return res;
    }
    
    bool dfs(string& res, int total, unordered_set<string>& visited, int k, int n) {
        if (visited.size() == total) {
            return true;
        }
        string prev = res.substr(res.size() - n + 1, n - 1);
        for (int i = 0; i < k; ++i) {
            string next = prev + to_string(i);
            if (visited.find(next) != visited.end()) {
                continue;
            }
            visited.insert(next);
            res += to_string(i);
            if (dfs(res, total, visited, k, n)) {
                return true;
            }
            visited.erase(next);
            res.pop_back();
        }
        return false;
    }
};