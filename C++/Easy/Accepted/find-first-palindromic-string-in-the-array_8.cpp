class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        
        for (auto w: words) {
            if (w == string(w.rbegin(), w.rend())) return w;
        }
        return "";
    }
};