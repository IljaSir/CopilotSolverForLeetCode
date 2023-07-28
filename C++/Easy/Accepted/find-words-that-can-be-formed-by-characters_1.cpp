class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int res = 0;
        vector<int> charCount(26, 0);
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (string& word : words) {
            vector<int> wordCount(26, 0);
            bool canForm = true;
            for (char c : word) {
                wordCount[c - 'a']++;
                if (wordCount[c - 'a'] > charCount[c - 'a']) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                res += word.size();
            }
        }
        return res;
    }
};