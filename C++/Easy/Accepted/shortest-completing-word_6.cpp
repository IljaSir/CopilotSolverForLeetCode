class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        int minLen = 15;
        int minIdx = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words[i].length() < minLen) {
                if (isCompletingWord(licensePlate, words[i])) {
                    minLen = words[i].length();
                    minIdx = i;
                }
            }
        }
        return words[minIdx];
    }
    
    bool isCompletingWord(string licensePlate, string word) {
        int count[26] = {0};
        for (auto c : word) {
            count[c - 'a']++;
        }
        for (auto c : licensePlate) {
            if (c >= 'A' && c <= 'Z') {
                c = c - 'A' + 'a';
            }
            if (c >= 'a' && c <= 'z') {
                if (--count[c - 'a'] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
};