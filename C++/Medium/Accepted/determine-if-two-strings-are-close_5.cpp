class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        if (word1.length() != word2.length()) return false;
        vector<int> cnt1(26, 0);
        vector<int> cnt2(26, 0);
        for (char c : word1) {
            cnt1[c - 'a']++;
        }
        for (char c : word2) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] == 0 && cnt2[i] > 0 || cnt1[i] > 0 && cnt2[i] == 0) {
                return false;
            }
        }
        sort(cnt1.begin(), cnt1.end());
        sort(cnt2.begin(), cnt2.end());
        return cnt1 == cnt2;
    }
};