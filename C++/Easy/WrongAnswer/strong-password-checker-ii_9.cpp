class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int l = password.length();
        if (l < 8) return false;
        bool hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password) {
            if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') hasSpecial = true;
        }
        if (!hasLower || !hasUpper || !hasDigit || !hasSpecial) return false;
        int count = 0, i = 0;
        while (i < l) {
            char c = password[i];
            int j = i + 1;
            while (j < l && password[j] == c) ++j;
            int len = j - i;
            if (len >= 3) count += len / 3;
            i = j;
        }
        return count <= 1;
    }
};