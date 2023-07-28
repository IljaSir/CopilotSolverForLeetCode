class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        unordered_map<char, string> pattern2word;
        unordered_map<string, char> word2pattern;
        int i = 0;
        int j = 0;
        while (i < pattern.size() && j < s.size()) {
            int k = j;
            while (k < s.size() && s[k] != ' ') {
                ++k;
            }
            string word = s.substr(j, k - j);
            if (pattern2word.count(pattern[i]) == 0) {
                pattern2word[pattern[i]] = word;
            } else {
                if (pattern2word[pattern[i]] != word) {
                    return false;
                }
            }
            if (word2pattern.count(word) == 0) {
                word2pattern[word] = pattern[i];
            } else {
                if (word2pattern[word] != pattern[i]) {
                    return false;
                }
            }
            ++i;
            j = k + 1;
        }
        if (i < pattern.size() || j < s.size()) {
            return false;
        }
        return true;
    }
};