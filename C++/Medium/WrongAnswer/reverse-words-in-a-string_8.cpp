class Solution {
public:
    string reverseWords(string s) {
        
        int n = s.size();
        if (n == 0) return s;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n) {
            while (i < n && s[i] == ' ') i++;
            j = i;
            while (j < n && s[j] != ' ') j++;
            reverse(s.begin() + i, s.begin() + j);
            if (k) s[k++] = ' ';
            for (int p = i; p < j; p++) s[k++] = s[p];
            i = j;
        }
        s.erase(s.begin() + k, s.end());
        reverse(s.begin(), s.end());
        return s;
    }
};