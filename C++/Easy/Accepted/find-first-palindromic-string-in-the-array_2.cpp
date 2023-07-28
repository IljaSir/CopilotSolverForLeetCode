class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for (string word : words) {
            string rev = word;
            reverse(rev.begin(), rev.end());
            if (word == rev) return word;
        }
        return "";
    }
};