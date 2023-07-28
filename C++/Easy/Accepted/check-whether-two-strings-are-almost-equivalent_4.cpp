class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        
        int n = word1.size();
        vector<int> freq1(26, 0), freq2(26, 0);
        for (int i = 0; i < n; ++i) {
            freq1[word1[i] - 'a']++;
            freq2[word2[i] - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (abs(freq1[i] - freq2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
};