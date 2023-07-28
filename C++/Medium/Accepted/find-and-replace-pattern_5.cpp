class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> res;
        for (auto w : words) {
            if (isMatch(w, pattern)) res.push_back(w);
        }
        return res;
    }
    bool isMatch(string word, string pattern) {
        map<char, char> m;
        map<char, char> m2;
        for (int i = 0; i < word.size(); i++) {
            if (m.find(word[i]) == m.end() && m2.find(pattern[i]) == m2.end()) {
                m[word[i]] = pattern[i];
                m2[pattern[i]] = word[i];
            } else {
                if (m[word[i]] != pattern[i]) return false;
            }
        }
        return true;
    }
};