class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> m;
        for (auto &s: allowed) {
            m[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, m);
    }
    bool dfs(string bottom, unordered_map<string, vector<char>> &m) {
        if (bottom.size() == 1) return true;
        if (bottom.size() == 2) {
            if (m.count(bottom)) return true;
            else return false;
        }
        vector<string> next;
        dfs(bottom, 0, "", m, next);
        for (auto &s: next) {
            if (dfs(s, m)) return true;
        }
        return false;
    }
    void dfs(string &bottom, int idx, string cur, unordered_map<string, vector<char>> &m, vector<string> &next) {
        if (cur.size() == bottom.size() - 1) {
            next.push_back(cur);
            return;
        }
        for (auto c: m[bottom.substr(idx, 2)]) {
            dfs(bottom, idx + 1, cur + c, m, next);
        }
    }
};