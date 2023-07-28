class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        if (n < 8) return false;
        bool hasLower = false, hasUpper = false, hasDigit = false;
        for (int i = 0; i < n; i++) {
            if (password[i] >= 'a' && password[i] <= 'z') hasLower = true;
            if (password[i] >= 'A' && password[i] <= 'Z') hasUpper = true;
            if (password[i] >= '0' && password[i] <= '9') hasDigit = true;
        }
        if (!hasLower || !hasUpper || !hasDigit) return false;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && password[j] == password[i]) j++;
            int len = j - i;
            if (len >= 3) return false;
            i = j;
        }
        return true;
    }
};