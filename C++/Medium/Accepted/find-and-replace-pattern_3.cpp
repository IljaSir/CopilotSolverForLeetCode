class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> ret;
        for (auto word: words) {
            if (match(word, pattern)) {
                ret.push_back(word);
            }
        }
        return ret;
    }
    bool match(string word, string pattern) {
        map<char, char> m;
        for (int i = 0; i < word.size(); i++) {
            if (m.find(pattern[i]) == m.end()) {
                m[pattern[i]] = word[i];
            }
            else {
                if (m[pattern[i]] != word[i]) {
                    return false;
                }
            }
        }
        map<char, char> m2;
        for (int i = 0; i < word.size(); i++) {
            if (m2.find(word[i]) == m2.end()) {
                m2[word[i]] = pattern[i];
            }
            else {
                if (m2[word[i]] != pattern[i]) {
                    return false;
                }
            }
        }
        return true;
    }
};