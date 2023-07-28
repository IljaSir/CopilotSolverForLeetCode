class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (isSimilar(words[i], words[j]))
                    count++;
            }
        }
        return count;
    }
    bool isSimilar(string& word1, string& word2) {
        if (word1.size() != word2.size())
            return false;
        int count = 0;
        for (int i = 0; i < word1.size(); i++) {
            if (word1[i] != word2[i])
                count++;
        }
        return count == 2 || count == 0;
    }
};