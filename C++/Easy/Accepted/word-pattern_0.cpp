class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        vector<string> words;
        string word;
        for (char c : s) {
            if (c == ' ') {
                words.push_back(word);
                word = "";
            } else {
                word += c;
            }
        }
        words.push_back(word);
        
        unordered_map<char, string> mp;
        unordered_set<string> st;
        if (words.size() != pattern.size()) return false;
        for (int i = 0; i < pattern.size(); ++i) {
            if (mp.find(pattern[i]) != mp.end()) {
                if (mp[pattern[i]] != words[i]) return false;
            } else {
                if (st.find(words[i]) != st.end()) return false;
                mp[pattern[i]] = words[i];
                st.insert(words[i]);
            }
        }
        return true;
    }
};