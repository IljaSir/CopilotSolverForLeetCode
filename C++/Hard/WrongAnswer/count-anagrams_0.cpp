class Solution {
public:
    int countAnagrams(string s) {
        
        int count = 0;
        vector<string> words;
        string word = "";
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') {
                words.push_back(word);
                word = "";
            } else {
                word += s[i];
            }
        }
        words.push_back(word);
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (isAnagram(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        
        vector<int> sCount(26, 0);
        vector<int> tCount(26, 0);
        for (int i = 0; i < s.size(); i++) {
            sCount[s[i] - 'a']++;
            tCount[t[i] - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        
        return true;
    }
};