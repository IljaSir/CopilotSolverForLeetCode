class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for (auto i: words) {
            string s = i;
            reverse(s.begin(), s.end());
            if (i == s) {
                return i;
            }
        }
        return "";
    }
};