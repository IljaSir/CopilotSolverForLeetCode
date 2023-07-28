class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        int i = 0, j = 0;
        string ans;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && j < word2.length()) {
                if (word1[i] > word2[j]) {
                    ans.push_back(word1[i++]);
                } else if (word1[i] < word2[j]) {
                    ans.push_back(word2[j++]);
                } else {
                    if (word1.substr(i) > word2.substr(j)) {
                        ans.push_back(word1[i++]);
                    } else {
                        ans.push_back(word2[j++]);
                    }
                }
            } else if (i < word1.length()) {
                ans.push_back(word1[i++]);
            } else {
                ans.push_back(word2[j++]);
            }
        }
        return ans;
    }
};