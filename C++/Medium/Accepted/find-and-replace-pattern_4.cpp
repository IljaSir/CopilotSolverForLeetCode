class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> ans;
        for (string word : words) {
            if (match(word, pattern)) ans.push_back(word);
        }
        return ans;
    }
    bool match(string word, string pattern) {
        unordered_map<char, char> mp;
        unordered_set<char> st;
        for (int i = 0; i < word.size(); i++) {
            if (mp.find(word[i]) == mp.end()) {
                if (st.find(pattern[i]) != st.end()) return false;
                mp[word[i]] = pattern[i];
                st.insert(pattern[i]);
            } else {
                if (mp[word[i]] != pattern[i]) return false;
            }
        }
        return true;
    }
};