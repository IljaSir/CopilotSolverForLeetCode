class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for (auto word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }
};