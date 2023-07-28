class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        unordered_map<string, vector<string>> memo;
        return wordBreak(s, dict, memo);
    }
    
    vector<string> wordBreak(string s, unordered_set<string>& dict, unordered_map<string, vector<string>>& memo) {
        if (memo.count(s)) {
            return memo[s];
        }
        vector<string> res;
        if (dict.count(s)) {
            res.push_back(s);
        }
        for (int i = 1; i < s.size(); i++) {
            string word = s.substr(i);
            if (dict.count(word)) {
                string rem = s.substr(0, i);
                vector<string> remRes = wordBreak(rem, dict, memo);
                for (string str: remRes) {
                    res.push_back(str + " " + word);
                }
            }
        }
        memo[s] = res;
        return res;
    }
};