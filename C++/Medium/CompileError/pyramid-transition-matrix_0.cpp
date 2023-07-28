class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> m;
        for (auto &s : allowed) {
            m[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, m);
    }
    bool dfs(string bottom, unordered_map<string, vector<char>> &m) {
        if (bottom.size() == 1) return true;
        vector<string> next;
        for (int i = 0; i < bottom.size() - 1; ++i) {
            string s = bottom.substr(i, 2);
            if (!m.count(s)) return false;
            next.push_back(m[s]);
        }
        return dfs(next);
    }
    bool dfs(vector<string> &next) {
        if (next.size() == 1) return true;
        vector<string> tmp;
        for (int i = 0; i < next.size() - 1; ++i) {
            string s;
            for (auto c1 : next[i]) {
                for (auto c2 : next[i + 1]) {
                    s.push_back(c1);
                    s.push_back(c2);
                    tmp.push_back(s);
                    s.clear();
                }
            }
        }
        return dfs(tmp);
    }
};