class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        int i = 0, j = 0;
        string result = "";
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && j < word2.length()) {
                if (word1[i] > word2[j]) {
                    result += word1[i++];
                } else if (word1[i] < word2[j]) {
                    result += word2[j++];
                } else {
                    int x = i + 1, y = j + 1;
                    while (x < word1.length() && y < word2.length()) {
                        if (word1[x] > word2[y]) {
                            result += word1[i++];
                            break;
                        } else if (word1[x] < word2[y]) {
                            result += word2[j++];
                            break;
                        } else {
                            x++;
                            y++;
                        }
                    }
                    if (x == word1.length() && y == word2.length()) {
                        result += word1[i++];
                    } else if (x == word1.length()) {
                        result += word2[j++];
                    } else if (y == word2.length()) {
                        result += word1[i++];
                    }
                }
            } else if (i < word1.length()) {
                result += word1[i++];
            } else if (j < word2.length()) {
                result += word2[j++];
            }
        }
        return result;
    }
};