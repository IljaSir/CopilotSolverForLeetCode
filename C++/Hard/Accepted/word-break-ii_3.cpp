class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        unordered_map<string, vector<string>> memo;
        return helper(s, dict, memo);
    }

    vector<string> helper(string s, unordered_set<string>& dict, unordered_map<string, vector<string>>& memo) {
        if (memo.count(s)) return memo[s];
        if (s.empty()) return {""};

        vector<string> res;
        for (int i = 1; i <= s.size(); ++i) {
            string word = s.substr(0, i);
            if (dict.count(word)) {
                vector<string> rem = helper(s.substr(i), dict, memo);
                for (string str : rem) {
                    res.push_back(word + (str.empty() ? "" : " ") + str);
                }
            }
        }
        memo[s] = res;
        return res;
    }
};