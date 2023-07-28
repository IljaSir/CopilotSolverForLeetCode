class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        if (n < 8) return false;
        int lower = 0, upper = 0, digit = 0, special = 0;
        for (char c : password) {
            if (c >= 'a' && c <= 'z') lower = 1;
            else if (c >= 'A' && c <= 'Z') upper = 1;
            else if (c >= '0' && c <= '9') digit = 1;
            else special = 1;
        }
        if (lower + upper + digit + special < 3) return false;
        int replace = 0, one = 0, two = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && password[i] == password[j]) j++;
            int k = j - i;
            replace += k / 3;
            if (k % 3 == 0) one++;
            else if (k % 3 == 1) two++;
        }
        if (n <= 20) return max(0, 3 - (lower + upper + digit + special)) <= replace;
        replace -= min(n - 20, one);
        replace -= min(max(n - 20 - one, 0), two * 2) / 2;
        replace -= max(n - 20 - one - 2 * two, 0) / 3;
        return replace <= 0;
    }
};