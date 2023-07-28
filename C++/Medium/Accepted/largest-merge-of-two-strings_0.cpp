class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string res;
        int i = 0, j = 0;
        while (i < word1.size() && j < word2.size()) {
            if (word1[i] > word2[j]) {
                res += word1[i];
                i++;
            } else if (word1[i] < word2[j]) {
                res += word2[j];
                j++;
            } else {
                int ii = i, jj = j;
                while (ii < word1.size() && jj < word2.size() && word1[ii] == word2[jj]) {
                    ii++;
                    jj++;
                }
                if (ii == word1.size()) {
                    res += word2[j];
                    j++;
                } else if (jj == word2.size()) {
                    res += word1[i];
                    i++;
                } else if (word1[ii] > word2[jj]) {
                    res += word1[i];
                    i++;
                } else {
                    res += word2[j];
                    j++;
                }
            }
        }
        while (i < word1.size()) {
            res += word1[i];
            i++;
        }
        while (j < word2.size()) {
            res += word2[j];
            j++;
        }
        return res;
    }
};