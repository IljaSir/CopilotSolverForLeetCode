class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for (auto& word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }
    
    bool isPalindrome(const string& word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word[i++] != word[j--]) {
                return false;
            }
        }
        return true;
    }
};