class Solution {
public:
    bool wordPattern(string pattern, string s) {
        
        map<char, string> p2s;
        map<string, char> s2p;
        int i = 0, j = 0;
        while (i < pattern.length() && j < s.length()) {
            int k = j;
            while (k < s.length() && s[k] != ' ') k++;
            string word = s.substr(j, k - j);
            if (p2s.find(pattern[i]) == p2s.end() && s2p.find(word) == s2p.end()) {
                p2s[pattern[i]] = word;
                s2p[word] = pattern[i];
            } else if (p2s.find(pattern[i]) != p2s.end() && s2p.find(word) != s2p.end()) {
                if (p2s[pattern[i]] != word || s2p[word] != pattern[i]) return false;
            } else return false;
            i++;
            j = k + 1;
        }
        return i == pattern.length() && j >= s.length();
    }
};