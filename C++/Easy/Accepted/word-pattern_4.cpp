class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        vector<string> words;
        int n = s.size();
        string word;
        for(int i = 0; i < n; i++) {
            if(s[i] == ' ') {
                words.push_back(word);
                word.clear();
            } else {
                word += s[i];
            }
        }
        if(word.size()) {
            words.push_back(word);
        }
        if(words.size() != pattern.size()) {
            return false;
        }
        unordered_map<string, char> mp;
        unordered_map<char, string> mp2;
        for(int i = 0; i < pattern.size(); i++) {
            if(mp.find(words[i]) == mp.end() && mp2.find(pattern[i]) == mp2.end()) {
                mp[words[i]] = pattern[i];
                mp2[pattern[i]] = words[i];
            } else {
                if(mp.find(words[i]) == mp.end() || mp2.find(pattern[i]) == mp2.end()) {
                    return false;
                }
                if(mp[words[i]] != pattern[i] || mp2[pattern[i]] != words[i]) {
                    return false;
                }
            }
        }
        return true;
    }
};