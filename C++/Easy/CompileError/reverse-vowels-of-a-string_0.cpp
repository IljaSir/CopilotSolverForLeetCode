class Solution {
public:
    string reverseVowels(string s) {
        
        int i = 0, j = s.size() - 1;
        while (i < j) {
            while (i < j && !isVowel(s[i])) i++;
            while (i < j && !isVowel(s[j])) j--;
            if (i < j) {
                swap(s[i], s[j]);
                i++;
                j--;
            }
        }
        return s;
    }
};