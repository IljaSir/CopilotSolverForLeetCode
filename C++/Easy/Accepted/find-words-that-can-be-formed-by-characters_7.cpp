class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int result = 0;
        int map[26] = {0};
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (string word : words) {
            int wordMap[26] = {0};
            bool valid = true;
            for (char c : word) {
                wordMap[c - 'a']++;
                if (wordMap[c - 'a'] > map[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result += word.length();
            }
        }
        return result;
    }
};