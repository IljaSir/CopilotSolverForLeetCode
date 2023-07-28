class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.length(), m = word2.length();
        if (n != m) return false;
        if (word1 == word2) return true;
        vector<int> w1(26), w2(26);
        for (int i = 0; i < n; i++) {
            w1[word1[i] - 'a']++;
            w2[word2[i] - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (w1[i] && w2[i]) cnt++;
        }
        return cnt >= 1;
    }
};