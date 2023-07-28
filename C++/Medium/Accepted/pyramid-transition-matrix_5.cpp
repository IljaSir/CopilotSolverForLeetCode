class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        int n = bottom.size();
        unordered_map<string, vector<char>> mp;
        for (string s : allowed) {
            mp[s.substr(0, 2)].push_back(s[2]);
        }
        return dfs(bottom, "", mp, 0, 0);
    }
    bool dfs(string& bottom, string next, unordered_map<string, vector<char>>& mp, int i, int j) {
        if (bottom.size() == 1) return true;
        if (j == bottom.size() - 1) return dfs(next, "", mp, 0, 0);
        string s = bottom.substr(i, 2);
        if (mp.count(s)) {
            for (char c : mp[s]) {
                if (dfs(bottom, next + c, mp, i + 1, j + 1)) return true;
            }
        }
        return false;
    }
};