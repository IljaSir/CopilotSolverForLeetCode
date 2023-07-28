class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string result;
        int i = 0, j = 0;
        while (i < word1.size() && j < word2.size()) {
            if (word1[i] > word2[j]) {
                result.push_back(word1[i++]);
            } else if (word1[i] < word2[j]) {
                result.push_back(word2[j++]);
            } else {
                int k = 1;
                while (i + k < word1.size() && j + k < word2.size()) {
                    if (word1[i + k] > word2[j + k]) {
                        result.push_back(word1[i++]);
                        break;
                    } else if (word1[i + k] < word2[j + k]) {
                        result.push_back(word2[j++]);
                        break;
                    }
                    k++;
                }
                if (i + k == word1.size()) {
                    result.push_back(word2[j++]);
                } else if (j + k == word2.size()) {
                    result.push_back(word1[i++]);
                }
            }
        }
        while (i < word1.size()) {
            result.push_back(word1[i++]);
        }
        while (j < word2.size()) {
            result.push_back(word2[j++]);
        }
        return result;
    }
};