class Solution {
public:
    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        for (auto &a : allowed) {
            m[a.substr(0, 2)].push_back(a[2]);
        }
        return dfs(0, bottom, "");
    }
};