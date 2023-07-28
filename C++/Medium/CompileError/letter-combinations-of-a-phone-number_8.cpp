class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        if (digits.empty()) return {};
        vector<string> result;
        string tmp;
        dfs(digits, 0, tmp, result);
        return result;
    }
    void dfs(string& digits, int index, string& tmp, vector<string>& result) {
        if (index == digits.size()) {
            result.push_back(tmp);
            return;
        }
        for (char c : m[digits[index] - '0']) {
            tmp.push_back(c);
            dfs(digits, index + 1, tmp, result);
            tmp.pop_back();
        }
    }
};