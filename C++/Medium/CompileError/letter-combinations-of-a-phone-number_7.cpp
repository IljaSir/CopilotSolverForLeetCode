class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        if (digits.empty()) return {};
        vector<string> res;
        string s;
        dfs(digits, 0, s, res);
        return res;
    }
    
    void dfs(string digits, int i, string s, vector<string>& res) {
        if (i == digits.size()) {
            res.push_back(s);
            return;
        }
        for (char c : m[digits[i]]) {
            dfs(digits, i + 1, s + c, res);
        }
    }
};