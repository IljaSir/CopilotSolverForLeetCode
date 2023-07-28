class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> result;
        for (auto word : words) {
            if (match(word, pattern)) {
                result.push_back(word);
            }
        }
        return result;
    }
    
    bool match(string word, string pattern) {
        unordered_map<char, char> w2p;
        unordered_map<char, char> p2w;
        for (int i = 0; i < word.size(); i++) {
            if (w2p.find(word[i]) == w2p.end()) {
                w2p[word[i]] = pattern[i];
            }
            if (p2w.find(pattern[i]) == p2w.end()) {
                p2w[pattern[i]] = word[i];
            }
            if (w2p[word[i]] != pattern[i] || p2w[pattern[i]] != word[i]) {
                return false;
            }
        }
        return true;
    }
};