class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int res = 0;
        vector<int> charCount(26, 0);
        for (auto c : chars) {
            charCount[c - 'a']++;
        }
        for (auto word : words) {
            vector<int> wordCount(26, 0);
            for (auto c : word) {
                wordCount[c - 'a']++;
            }
            bool isGood = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                res += word.size();
            }
        }
        return res;
    }
};