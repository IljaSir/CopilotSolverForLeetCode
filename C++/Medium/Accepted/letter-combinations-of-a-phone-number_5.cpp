class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> ans;
        if (digits.size() == 0) return ans;
        unordered_map<char, string> mp = {
            {'2', "abc"},
            {'3', "def"},
            {'4', "ghi"},
            {'5', "jkl"},
            {'6', "mno"},
            {'7', "pqrs"},
            {'8', "tuv"},
            {'9', "wxyz"}
        };
        string s;
        dfs(ans, mp, digits, 0, s);
        return ans;
    }
    void dfs(vector<string>& ans, unordered_map<char, string>& mp, string& digits, int idx, string& s) {
        if (idx == digits.size()) {
            ans.push_back(s);
            return;
        }
        char c = digits[idx];
        for (char ch : mp[c]) {
            s.push_back(ch);
            dfs(ans, mp, digits, idx + 1, s);
            s.pop_back();
        }
    }
};