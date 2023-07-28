class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        if (n < 8) return false;
        bool hasLower = false;
        bool hasUpper = false;
        bool hasDigit = false;
        bool hasSpecial = false;
        for (char c : password) {
            if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else hasSpecial = true;
        }
        if (!hasLower || !hasUpper || !hasDigit || !hasSpecial) return false;
        int cnt = 0, i = 0;
        while (i < n) {
            int j = i;
            while (j < n && password[i] == password[j]) j++;
            cnt += j - i;
            i = j;
        }
        if (cnt > 1) return false;
        return true;
    }
};