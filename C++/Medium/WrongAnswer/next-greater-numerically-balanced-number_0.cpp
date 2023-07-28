class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        if (n < 10) return n + 1;
        string s = to_string(n);
        int i = s.size() - 1;
        while (i > 0 && s[i] <= s[i - 1]) --i;
        if (i == 0) return n + 1;
        int j = s.size() - 1;
        while (j > i && s[j] <= s[i - 1]) --j;
        swap(s[i - 1], s[j]);
        sort(s.begin() + i, s.end());
        return stoi(s);
    }
};