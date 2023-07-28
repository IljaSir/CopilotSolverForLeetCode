class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        istringstream iss(s);
        vector<string> words;
        for (string word; iss >> word; ) {
            words.push_back(word);
        }
        if (words.size() != pattern.size()) {
            return false;
        }
        unordered_map<char, string> p2w;
        unordered_map<string, char> w2p;
        for (int i = 0; i < pattern.size(); ++i) {
            if (p2w.count(pattern[i]) && p2w[pattern[i]] != words[i]) {
                return false;
            }
            if (w2p.count(words[i]) && w2p[words[i]] != pattern[i]) {
                return false;
            }
            p2w[pattern[i]] = words[i];
            w2p[words[i]] = pattern[i];
        }
        return true;
    }
};