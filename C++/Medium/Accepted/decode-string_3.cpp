class Solution {
public:
    string decodeString(string s) {
        
        int n = s.size();
        string res;
        int i = 0;
        while (i < n) {
            if (s[i] >= '0' && s[i] <= '9') {
                int k = 0;
                while (s[i] >= '0' && s[i] <= '9') {
                    k = k * 10 + s[i++] - '0';
                }
                int j = i;
                int cnt = 0;
                while (j < n) {
                    if (s[j] == '[') cnt++;
                    if (s[j] == ']') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                string t = decodeString(s.substr(i + 1, j - i - 1));
                while (k--) res += t;
                i = j + 1;
            } else {
                res += s[i++];
            }
        }
        return res;
    }
};