class Solution {
public:
    string longestWord(vector<string>& words) {
        
        unordered_set<string> dict(words.begin(), words.end());
        string res;
        for (string word: words) {
            if (word.size() > res.size() || (word.size() == res.size() && word < res)) {
                string prefix;
                for (int i = 0; i < word.size(); ++i) {
                    prefix += word[i];
                    if (!dict.count(prefix)) {
                        break;
                    }
                    if (i == word.size() - 1) {
                        res = word;
                    }
                }
            }
        }
        return res;
    }
};