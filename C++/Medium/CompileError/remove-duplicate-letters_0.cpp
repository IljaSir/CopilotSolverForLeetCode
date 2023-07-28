class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int cnt[26] = {0};
        for (char c : s) cnt[c - 'a']++;
        int pos = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] < s[pos]) pos = i;
            if (--cnt[s[i] - 'a'] == 0) break;
        }
        return s.empty() ? "" : s[pos] + removeDuplicateLetters(s.substr(pos + 1).erase(std::remove(s.begin() + pos + 1, s.end(), s[pos]), s.end()));
    }
};