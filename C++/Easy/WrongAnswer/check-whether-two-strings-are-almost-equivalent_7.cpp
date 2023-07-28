class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int n = word1.size();
        if (n != word2.size()) {
            return false;
        }
        vector<int> c1(26, 0), c2(26, 0);
        for (int i = 0; i < n; ++i) {
            c1[word1[i] - 'a']++;
            c2[word2[i] - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; ++i) {
            diff += abs(c1[i] - c2[i]);
        }
        return diff <= 3;
    }
};