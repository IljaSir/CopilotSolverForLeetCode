class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.size();
        int a = 0, b = 0, c = 0;
        int i = 0, j = n - 1;
        for (; i < j; ++i, --j) {
            if (s[i] == 'a') ++a;
            if (s[i] == 'b') ++b;
            if (s[i] == 'c') ++c;
            if (s[j] == 'a') ++a;
            if (s[j] == 'b') ++b;
            if (s[j] == 'c') ++c;
            if (a >= k && b >= k && c >= k) return i + n - j;
        }
        if (i == j) {
            if (s[i] == 'a') ++a;
            if (s[i] == 'b') ++b;
            if (s[i] == 'c') ++c;
        }
        if (a >= k && b >= k && c >= k) return i + n - j;
        return -1;
    }
};