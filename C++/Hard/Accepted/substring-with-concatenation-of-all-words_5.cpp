class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> res;
        if (words.empty()) return res;
        int wordLen = words[0].length();
        int wordNum = words.size();
        int sLen = s.length();
        int totalLen = wordLen * wordNum;
        if (sLen < totalLen) return res;
        unordered_map<string, int> wordCount;
        for (string word : words) {
            wordCount[word]++;
        }
        for (int i = 0; i <= sLen - totalLen; i++) {
            unordered_map<string, int> seen;
            int j = 0;
            for (; j < wordNum; j++) {
                string word = s.substr(i + j * wordLen, wordLen);
                if (wordCount.find(word) == wordCount.end() || seen[word] >= wordCount[word]) {
                    break;
                }
                seen[word]++;
            }
            if (j == wordNum) {
                res.push_back(i);
            }
        }
        return res;
    }
};