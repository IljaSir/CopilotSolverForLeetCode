class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        
        int result = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words[i][0] == words[j][1] && words[i][1] == words[j][0]) {
                    result += 2;
                }
            }
        }
        int odd = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words[i][0] == words[i][1]) {
                odd = 1;
            }
        }
        return result + odd;
    }
};