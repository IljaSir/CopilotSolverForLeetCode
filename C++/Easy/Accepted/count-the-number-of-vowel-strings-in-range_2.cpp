class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            string word = words[i];
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u') {
                if (word[word.length() - 1] == 'a' || word[word.length() - 1] == 'e' || word[word.length() - 1] == 'i' || word[word.length() - 1] == 'o' || word[word.length() - 1] == 'u') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
};