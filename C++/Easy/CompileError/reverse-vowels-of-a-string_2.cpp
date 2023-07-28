class Solution {
public:
    string reverseVowels(string s) {
        
        int l = 0, r = s.size() - 1;
        while (l < r) {
            while (l < r && !isVowel(s[l])) l++;
            while (l < r && !isVowel(s[r])) r--;
            swap(s[l++], s[r--]);
        }
        return s;
    }
};