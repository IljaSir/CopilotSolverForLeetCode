class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();
        int len = min(len1, len2);
        for (int i = len; i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                string str = str1.substr(0, i);
                if (isDivide(str1, str) && isDivide(str2, str)) {
                    return str;
                }
            }
        }
        return "";
    }
    bool isDivide(string str, string div) {
        int len = div.length();
        int i = 0;
        while (i < str.length()) {
            if (str.substr(i, len) != div) {
                return false;
            }
            i += len;
        }
        return true;
    }
};