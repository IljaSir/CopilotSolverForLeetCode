class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> m;
        for (auto &s : allowed) m[s.substr(0, 2)].push_back(s[2]);
        return dfs(bottom, "", 0, 1, m);
    }
    bool dfs(string &bottom, string next, int i, int j, unordered_map<string, vector<char>> &m) {
        if (bottom.size() == 2 && m.find(bottom) != m.end()) return true;
        if (bottom.size() == 1) return true;
        if (i == bottom.size() - 1) return dfs(next, "", 0, 1, m);
        string key = bottom.substr(i, 2);
        if (m.find(key) == m.end()) return false;
        for (auto c : m[key]) {
            if (dfs(bottom, next + c, i + 1, j + 1, m)) return true;
        }
        return false;
    }
};