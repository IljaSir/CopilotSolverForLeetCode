class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        int minLen = INT_MAX;
        int minIdx = -1;
        for (int i = 0; i < words.size(); ++i) {
            string word = words[i];
            int len = word.size();
            if (len < minLen && isCompletingWord(licensePlate, word)) {
                minLen = len;
                minIdx = i;
            }
        }
        return words[minIdx];
    }
    bool isCompletingWord(string licensePlate, string word) {
        int count[26] = {0};
        for (char ch : word) {
            if (isalpha(ch)) {
                ++count[tolower(ch) - 'a'];
            }
        }
        for (char ch : licensePlate) {
            if (isalpha(ch)) {
                if (--count[tolower(ch) - 'a'] < 0) return false;
            }
        }
        return true;
    }
};