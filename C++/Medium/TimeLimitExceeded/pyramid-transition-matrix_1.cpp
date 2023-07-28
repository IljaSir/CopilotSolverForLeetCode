class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> m;
        for (auto& s: allowed) {
            m[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, "", m);
    }
    bool dfs(string bottom, string next, unordered_map<string, vector<char>>& m) {
        if (bottom.size() == 1) return true;
        if (next.size() == bottom.size() - 1) return dfs(next, "", m);
        string key = bottom.substr(next.size(), 2);
        if (!m.count(key)) return false;
        for (auto c: m[key]) {
            if (dfs(bottom, next + c, m)) return true;
        }
        return false;
    }
};