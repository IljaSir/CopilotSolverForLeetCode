class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        string s = to_string(n);
        int len = s.size();
        int start = 0;
        while (start < len && s[start] == '9') {
            start++;
        }
        if (start == len) {
            return n + 2;
        }
        s[start]++;
        for (int i = start - 1; i >= 0; i--) {
            s[i] = s[i + 1];
        }
        for (int i = start + 1; i < len; i++) {
            s[i] = '0';
        }
        return stoi(s);
    }
};