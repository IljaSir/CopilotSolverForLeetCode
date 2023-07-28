class Solution {
public:
    string largestPalindromic(string num) {
        
        sort(num.begin(), num.end());
        reverse(num.begin(), num.end());
        return num;
    }
};