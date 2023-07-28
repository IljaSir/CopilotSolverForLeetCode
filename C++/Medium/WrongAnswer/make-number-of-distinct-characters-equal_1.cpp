class Solution {
public:
    bool isItPossible(string word1, string word2) {
        
        int n = word1.length();
        int m = word2.length();
        if (n != m) {
            return false;
        }
        int count[26] = {0};
        for (int i = 0; i < n; i++) {
            count[word1[i] - 'a']++;
            count[word2[i] - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += abs(count[i]);
        }
        return sum == 2;
    }
};