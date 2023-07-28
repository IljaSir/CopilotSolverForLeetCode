class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        int minLen = 1001;
        string ans;
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            if (word.size() < minLen) {
                int j = 0;
                for (; j < word.size(); j++) {
                    char c = word[j];
                    if (licensePlate.find(c) == string::npos &&
                        licensePlate.find(tolower(c)) == string::npos) {
                        break;
                    }
                }
                if (j == word.size()) {
                    minLen = word.size();
                    ans = word;
                }
            }
        }
        return ans;
    }
};