class Solution {
public:
    vector<string> letterCasePermutation(string s) {
        
        vector<string> res;
        dfs(s, 0, res);
        return res;
    }
    
    void dfs(string s, int start, vector<string>& res) {
        if (start == s.size()) {
            res.push_back(s);
            return;
        }
        
        if (isdigit(s[start])) {
            dfs(s, start + 1, res);
        } else {
            dfs(s, start + 1, res);
            s[start] ^= 1 << 5;
            dfs(s, start + 1, res);
        }
    }
};