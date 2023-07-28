class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.length();
        if (n < 8) return false;
        int lower = 0, upper = 0, digit = 0, special = 0;
        for (char c : password) {
            if (isdigit(c)) digit = 1;
            else if (isupper(c)) upper = 1;
            else if (islower(c)) lower = 1;
            else special = 1;
        }
        int missing = (4 - (lower + upper + digit + special));
        if (n <= 20) return missing == 0;
        int del = n - 20;
        int rep = 0, one = 0, two = 0;
        for (int i = 0, j; i < n; i = j) {
            for (j = i; j < n && password[i] == password[j]; ++j);
            int l = j - i;
            if (l >= 3) {
                rep += l / 3;
                if (l % 3 == 0) one++;
                else if (l % 3 == 1) two++;
            }
        }
        if (del > rep) {
            del -= rep;
            one -= min(del, one);
            del -= min(del, one);
            two -= min(del, two);
            del -= min(del, two);
            missing -= min(del, missing);
        } else {
            rep -= del;
            one -= min(del, one);
            del -= min(del, one);
            two -= min(del, two);
            del -= min(del, two);
            missing -= min(del, missing);
        }
        return missing == 0;
    }
};