class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        vector<string> res;
        vector<int> memo(s.size(), 0);
        dfs(s, dict, 0, "", res, memo);
        return res;
    }
    void dfs(string& s, unordered_set<string>& dict, int start, string out, vector<string>& res, vector<int>& memo) {
        if (start == s.size()) {
            res.push_back(out);
            return;
        }
        if (memo[start] == -1) return;
        for (int i = start; i < s.size(); ++i) {
            string t = s.substr(start, i - start + 1);
            if (dict.count(t)) {
                string tmp = out;
                if (out.size() > 0) {
                    out += " ";
                }
                out += t;
                dfs(s, dict, i + 1, out, res, memo);
                out = tmp;
            }
        }
        memo[start] = -1;
    }
};