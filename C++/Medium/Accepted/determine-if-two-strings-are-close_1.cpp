class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        if (word1.length() != word2.length()) {
            return false;
        }
        vector<int> cnt1(26, 0);
        vector<int> cnt2(26, 0);
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1[i] - 'a']++;
            cnt2[word2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((cnt1[i] && cnt2[i] == 0) || (cnt1[i] == 0 && cnt2[i])) {
                return false;
            }
        }
        sort(cnt1.begin(), cnt1.end());
        sort(cnt2.begin(), cnt2.end());
        return cnt1 == cnt2;
    }
};