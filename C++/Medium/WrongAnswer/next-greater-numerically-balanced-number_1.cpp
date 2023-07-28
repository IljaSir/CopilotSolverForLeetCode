class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        string s = to_string(n);
        int i = s.size() - 1;
        while (i >= 0 && s[i] == '9') i--;
        if (i < 0) return 11;
        int j = i - 1;
        while (j >= 0 && s[j] == s[i]) j--;
        int d = i - j;
        if (d + 1 > s[i] - '0') {
            s[i] = s[i] + 1;
            for (int k = i + 1; k < s.size(); k++) s[k] = '0';
            return stoi(s);
        }
        s[i] = s[i] - 1;
        s[j] = s[i];
        for (int k = j + 1; k < i; k++) s[k] = '9';
        return stoi(s);
    }
};