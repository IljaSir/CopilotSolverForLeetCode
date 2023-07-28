class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words[i].size() <= s.size()) {
                bool isPrefix = true;
                for (int j = 0; j < words[i].size(); j++) {
                    if (words[i][j] != s[j]) {
                        isPrefix = false;
                        break;
                    }
                }
                if (isPrefix) count++;
            }
        }
        return count;
    }
};