class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();
        int len = min(len1, len2);
        string res = "";
        for (int i = 0; i < len; i++) {
            if (str1[i] == str2[i]) {
                res += str1[i];
            } else {
                break;
            }
        }
        if (res.length() == 0) {
            return "";
        }
        int i = 0;
        while (i < len1) {
            if (str1[i] != res[i % res.length()]) {
                return "";
            }
            i++;
        }
        i = 0;
        while (i < len2) {
            if (str2[i] != res[i % res.length()]) {
                return "";
            }
            i++;
        }
        return res;
    }
};