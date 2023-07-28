class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        map<string, vector<char>> mp;
        for (auto& s: allowed) {
            mp[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, "", 0, mp);
    }
    bool dfs(string& bottom, string cur, int i, map<string, vector<char>>& mp) {
        if (bottom.size() == 1) return true;
        if (cur.size() == bottom.size() - 1) return dfs(cur, "", 0, mp);
        string key = bottom.substr(i, 2);
        if (mp.count(key) == 0) return false;
        for (auto& c: mp[key]) {
            if (dfs(bottom, cur + c, i + 1, mp)) return true;
        }
        return false;
    }
};