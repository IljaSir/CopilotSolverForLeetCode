class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        unordered_map<string, vector<char>> mp;
        for (auto& str: allowed) {
            mp[str.substr(0, 2)].push_back(str[2]);
        }
        return dfs(bottom, mp);
    }
    
    bool dfs(string& bottom, unordered_map<string, vector<char>>& mp) {
        if (bottom.size() == 1) return true;
        vector<string> next;
        vector<vector<char>> choices;
        for (int i = 0; i < bottom.size() - 1; i++) {
            string key = bottom.substr(i, 2);
            if (mp.find(key) == mp.end()) return false;
            choices.push_back(mp[key]);
        }
        dfs(bottom, mp, 0, "", next, choices);
        for (auto& str: next) {
            if (dfs(str, mp)) return true;
        }
        return false;
    }
    
    void dfs(string& bottom, unordered_map<string, vector<char>>& mp, int idx, string path, vector<string>& next, vector<vector<char>>& choices) {
        if (idx == bottom.size() - 1) {
            next.push_back(path);
            return;
        }
        for (auto& c: choices[idx]) {
            dfs(bottom, mp, idx + 1, path + c, next, choices);
        }
    }
};