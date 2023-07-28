class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;
        vector<int> cnt1(26, 0);
        vector<int> cnt2(26, 0);
        for (int i = 0; i < n; i++) {
            cnt1[word1[i] - 'a']++;
            cnt2[word2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((cnt1[i] > 0 && cnt2[i] == 0) || (cnt1[i] == 0 && cnt2[i] > 0)) return false;
        }
        sort(cnt1.begin(), cnt1.end());
        sort(cnt2.begin(), cnt2.end());
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
};