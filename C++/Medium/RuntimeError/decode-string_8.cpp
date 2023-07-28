class Solution {
public:
    string decodeString(string s) {
        
        int n = s.size();
        int i = 0;
        string result;
        while(i < n) {
            if (isdigit(s[i])) {
                int num = 0;
                while (i < n && isdigit(s[i])) {
                    num = num * 10 + s[i] - '0';
                    i++;
                }
                i++; // skip '['
                string sub = decodeString(s);
                while (num > 0) {
                    result += sub;
                    num--;
                }
                i++; // skip ']'
            } else if (isalpha(s[i])) {
                result += s[i];
                i++;
            }
        }
        return result;
    }
};