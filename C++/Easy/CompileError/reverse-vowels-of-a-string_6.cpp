class Solution {
public:
    string reverseVowels(string s) {
        
        int start = 0, end = s.size() - 1;
        while (start < end) {
            if (isVowel(s[start]) && isVowel(s[end])) {
                swap(s[start], s[end]);
                ++start;
                --end;
            } else if (isVowel(s[start])) {
                --end;
            } else if (isVowel(s[end])) {
                ++start;
            } else {
                ++start;
                --end;
            }
        }
        return s;
    }
};