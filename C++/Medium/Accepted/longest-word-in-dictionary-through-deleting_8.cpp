class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        
        string ans;
        for (auto& word: dictionary) {
            if (word.length() < ans.length()) continue;
            if (word.length() == ans.length() && word > ans) continue;
            if (isSubsequence(word, s)) {
                ans = word;
            }
        }
        return ans;
    }
    bool isSubsequence(string& s, string& t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s[i] == t[j]) ++i;
            ++j;
        }
        return i == s.length();
    }
};