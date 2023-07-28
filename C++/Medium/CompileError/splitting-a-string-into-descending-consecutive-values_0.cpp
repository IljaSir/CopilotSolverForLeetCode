class Solution {
public:
    bool splitString(string s) {
        
        for (int i = 1; i < s.size(); i++) {
            if (dfs(s, i, stoll(s.substr(0, i)))) {
                return true;
            }
        }
        return false;
    }
};