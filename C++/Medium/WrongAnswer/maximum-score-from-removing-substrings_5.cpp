class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        string s1 = "ab", s2 = "ba";
        if (x < y) {
            swap(x, y);
            swap(s1, s2);
        }
        int n = s.size();
        int res = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (s[i] == s1[0]) {
                j = i + 1;
                while (j < n && s[j] != s1[1]) j++;
                if (j < n) {
                    res += x;
                    s.erase(i, 2);
                    n -= 2;
                } else {
                    i++;
                }
            } else if (s[i] == s2[0]) {
                j = i + 1;
                while (j < n && s[j] != s2[1]) j++;
                if (j < n) {
                    res += y;
                    s.erase(i, 2);
                    n -= 2;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }
};