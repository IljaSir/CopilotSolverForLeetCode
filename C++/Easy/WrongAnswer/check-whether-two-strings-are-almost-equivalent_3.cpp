class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int n = word1.length();
        vector<int> cnt1(26, 0);
        vector<int> cnt2(26, 0);
        for (int i = 0; i < n; i++) {
            cnt1[word1[i] - 'a']++;
            cnt2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += abs(cnt1[i] - cnt2[i]);
        }
        return diff <= 3;
    }
};