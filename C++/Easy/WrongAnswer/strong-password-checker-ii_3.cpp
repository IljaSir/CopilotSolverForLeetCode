class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        if (n < 8) return false;
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (char c : password) {
            if (isupper(c)) upper = 1;
            else if (islower(c)) lower = 1;
            else if (isdigit(c)) digit = 1;
            else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '+' || c == '-') special = 1;
        }
        if (upper + lower + digit + special < 3) return false;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && password[j] == password[i]) j++;
            if (j - i >= 3) {
                if (upper + lower + digit + special < 4) return false;
                if (n < 12) return true;
                int k = j - i - 2;
                if (k % 3 == 0) {
                    if (upper + lower + digit + special < 5) return false;
                    if (n < 14) return true;
                }
            }
            i = j;
        }
        return true;
    }
};