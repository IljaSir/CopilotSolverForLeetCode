class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int n = password.size();
        int need = 3;
        if (n > 5) need--;
        if (n > 8) need--;
        int lower = 1, upper = 1, digit = 1;
        for (char c : password) {
            if (islower(c)) lower = 0;
            if (isupper(c)) upper = 0;
            if (isdigit(c)) digit = 0;
        }
        int missing = (lower + upper + digit);
        if (n < 6) {
            return max(need, missing);
        }
        int one = 0, two = 0;
        for (int i = 0, j; i < n; i = j) {
            for (j = i; j < n && password[i] == password[j]; j++);
            int len = j - i;
            if (len >= 3) {
                one += len / 3;
                if (len % 3 == 0) two++;
            }
        }
        if (n <= 20) {
            return max(need, missing) + one;
        }
        int del = n - 20;
        one -= min(del, one);
        two -= min(max(del - one, 0), two * 2) / 2;
        three -= min(max(del - one - 2 * two, 0), three * 3) / 3;
        return del + max(need, missing) + one + two + three;
    }
};