class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        if (word1.length() != word2.length()) return false;
        int cnt1[26] = {0}, cnt2[26] = {0};
        for (auto c : word1) cnt1[c - 'a']++;
        for (auto c : word2) cnt2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if ((!cnt1[i] && cnt2[i]) || (cnt1[i] && !cnt2[i])) return false;
        }
        sort(cnt1, cnt1 + 26);
        sort(cnt2, cnt2 + 26);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
};