class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        if (password.length() < 8) return false;
        bool lower = false, upper = false, digit = false;
        int i = 0;
        while (i < password.length()) {
            if (password[i] >= 'a' && password[i] <= 'z') lower = true;
            else if (password[i] >= 'A' && password[i] <= 'Z') upper = true;
            else if (password[i] >= '0' && password[i] <= '9') digit = true;
            else return false;
            i++;
        }
        return lower && upper && digit;
    }
};