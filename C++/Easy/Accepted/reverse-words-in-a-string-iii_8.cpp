class Solution {
public:
    string reverseWords(string s) {
        
        int i = 0, j = 0;
        while (i < s.size()) {
            while (j < s.size() && s[j] != ' ') {
                j++;
            }
            int start = i, end = j - 1;
            while (start < end) {
                swap(s[start], s[end]);
                start++;
                end--;
            }
            i = j + 1;
            j = i;
        }
        return s;
    }
};