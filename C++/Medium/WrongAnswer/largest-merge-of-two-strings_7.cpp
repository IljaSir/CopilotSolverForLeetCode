class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string merge = "";
        int i = 0, j = 0;
        while(i < word1.size() && j < word2.size()) {
            if (word1[i] > word2[j]) {
                merge.push_back(word1[i]);
                i++;
            } else if (word1[i] < word2[j]) {
                merge.push_back(word2[j]);
                j++;
            } else {
                int k = i + 1, l = j + 1;
                while(k < word1.size() && l < word2.size() && word1[k] == word2[l]) {
                    k++;
                    l++;
                }
                if (k < word1.size() && l < word2.size() && word1[k] > word2[l]) {
                    merge.push_back(word1[i]);
                    i++;
                } else {
                    merge.push_back(word2[j]);
                    j++;
                }
            }
        }
        while(i < word1.size()) {
            merge.push_back(word1[i]);
            i++;
        }
        while(j < word2.size()) {
            merge.push_back(word2[j]);
            j++;
        }
        return merge;
    }
};