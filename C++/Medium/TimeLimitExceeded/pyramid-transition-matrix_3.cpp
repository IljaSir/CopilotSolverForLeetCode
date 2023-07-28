class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> mp;
        for (auto& s : allowed) {
            mp[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, "", mp);
    }
    
    bool dfs(string bottom, string next, unordered_map<string, vector<char>>& mp) {
        if (bottom.size() == 1) return true;
        if (next.size() == bottom.size() - 1) return dfs(next, "", mp);
        string key = bottom.substr(next.size(), 2);
        if (mp.count(key) == 0) return false;
        for (auto& c : mp[key]) {
            if (dfs(bottom, next + c, mp)) return true;
        }
        return false;
    }
};