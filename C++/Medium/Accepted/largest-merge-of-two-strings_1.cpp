class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string merge;
        int i = 0, j = 0;
        while (i < word1.size() && j < word2.size()) {
            if (word1[i] > word2[j]) {
                merge += word1[i++];
            } else if (word1[i] < word2[j]) {
                merge += word2[j++];
            } else {
                int k = 1;
                while (i + k < word1.size() && j + k < word2.size()) {
                    if (word1[i + k] == word2[j + k]) {
                        k++;
                    } else {
                        break;
                    }
                }
                if (i + k >= word1.size()) {
                    merge += word2[j++];
                } else if (j + k >= word2.size()) {
                    merge += word1[i++];
                } else {
                    if (word1[i + k] > word2[j + k]) {
                        merge += word1[i++];
                    } else {
                        merge += word2[j++];
                    }
                }
            }
        }
        if (i < word1.size()) {
            merge += word1.substr(i);
        }
        if (j < word2.size()) {
            merge += word2.substr(j);
        }
        return merge;
    }
};