class Solution {
public:
    string reformatNumber(string number) {
        
        string digits = "";
        for (char c : number) {
            if (c >= '0' && c <= '9') {
                digits += c;
            }
        }
        
        string result = "";
        int n = digits.length();
        for (int i = 0; i < n; i += 3) {
            if (i + 4 < n) {
                result += digits.substr(i, 3) + "-";
            } else if (i + 2 == n) {
                result += digits.substr(i, 2);
            } else {
                result += digits.substr(i, 3);
            }
        }
        return result;
    }
};