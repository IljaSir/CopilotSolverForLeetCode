class Solution {
public:
    string reverseVowels(string s) {
        
        int n = s.size();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < j && !isVowel(s[i])) i++;
            while (i < j && !isVowel(s[j])) j--;
            swap(s[i], s[j]);
            i++;
            j--;
        }
        return s;
    }
};