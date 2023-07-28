class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int vCount = 0;
        for (int i = left; i <= right; i++) {
            string word = words[i];
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u') {
                if (word[word.size() - 1] == 'a' || word[word.size() - 1] == 'e' || word[word.size() - 1] == 'i' || word[word.size() - 1] == 'o' || word[word.size() - 1] == 'u') {
                    vCount++;
                }
            }
        }
        return vCount;
    }
};