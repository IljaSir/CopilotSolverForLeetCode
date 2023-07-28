class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> m;
        for (auto& s : allowed) {
            m[s.substr(0, 2)].push_back(s[2]);
        }
        return build(bottom, "", m);
    }
    bool build(string cur, string next, unordered_map<string, vector<char>>& m) {
        if (cur.size() == 1) return true;
        if (next.size() == cur.size() - 1) return build(next, "", m);
        for (auto& c : m[cur.substr(next.size(), 2)]) {
            if (build(cur, next + c, m)) return true;
        }
        return false;
    }
};