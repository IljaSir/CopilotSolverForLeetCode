class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> result;
        if (words.size() == 0) return result;
        unordered_map<string, int> wordMap;
        int wordLength = words[0].length();
        int wordCount = words.size();
        int wordTotalLength = wordLength * wordCount;
        int sLength = s.length();
        for (auto word : words) {
            wordMap[word]++;
        }
        for (int i = 0; i <= sLength - wordTotalLength; i++) {
            unordered_map<string, int> wordSeen;
            int count = 0;
            for (int j = i; j < i + wordTotalLength; j += wordLength) {
                string word = s.substr(j, wordLength);
                if (wordMap.find(word) != wordMap.end()) {
                    wordSeen[word]++;
                    if (wordSeen[word] > wordMap[word]) {
                        break;
                    }
                    count++;
                } else {
                    break;
                }
            }
            if (count == wordCount) {
                result.push_back(i);
            }
        }
        return result;
    }
};