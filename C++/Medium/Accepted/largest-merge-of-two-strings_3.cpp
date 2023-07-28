class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string result;
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1[i] > word2[j]) {
                result += word1[i];
                i++;
            } else if (word1[i] < word2[j]) {
                result += word2[j];
                j++;
            } else {
                int k = 1;
                while (i + k < word1.length() && j + k < word2.length() && word1[i + k] == word2[j + k]) {
                    k++;
                }
                if (i + k < word1.length() && j + k < word2.length()) {
                    if (word1[i + k] > word2[j + k]) {
                        result += word1[i];
                        i++;
                    } else {
                        result += word2[j];
                        j++;
                    }
                } else if (i + k < word1.length()) {
                    result += word1[i];
                    i++;
                } else {
                    result += word2[j];
                    j++;
                }
            }
        }
        while (i < word1.length()) {
            result += word1[i];
            i++;
        }
        while (j < word2.length()) {
            result += word2[j];
            j++;
        }
        return result;
    }
};