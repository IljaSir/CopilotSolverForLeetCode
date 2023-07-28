class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        int minLen = 16;
        string minWord = "";
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            if (word.length() < minLen) {
                if (isCompletingWord(licensePlate, word)) {
                    minLen = word.length();
                    minWord = word;
                }
            }
        }
        return minWord;
    }
    
    bool isCompletingWord(string licensePlate, string word) {
        map<char, int> charMap;
        for (int i = 0; i < word.length(); i++) {
            char c = word[i];
            if (charMap.find(c) == charMap.end()) {
                charMap[c] = 1;
            } else {
                charMap[c]++;
            }
        }
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate[i];
            if (c >= 'A' && c <= 'Z') {
                c = c - 'A' + 'a';
            }
            if (c >= 'a' && c <= 'z') {
                if (charMap.find(c) == charMap.end() || charMap[c] == 0) {
                    return false;
                } else {
                    charMap[c]--;
                }
            }
        }
        return true;
    }
};