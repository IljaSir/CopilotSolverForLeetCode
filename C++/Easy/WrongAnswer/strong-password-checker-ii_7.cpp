class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        if (n < 8) return false;
        int cnt[4] = {0};
        for (auto c : password) {
            if (c >= 'a' && c <= 'z') cnt[0] = 1;
            if (c >= 'A' && c <= 'Z') cnt[1] = 1;
            if (c >= '0' && c <= '9') cnt[2] = 1;
            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') cnt[3] = 1;
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) sum += cnt[i];
        if (sum == 4) return true;
        if (sum == 3) {
            if (n >= 10) return true;
            for (int i = 0; i < n - 2; i++) {
                if (password[i] == password[i + 1] && password[i + 1] == password[i + 2]) return true;
            }
            return false;
        }
        if (sum == 2) {
            if (n >= 10) return true;
            int cnt = 0;
            for (int i = 0; i < n - 2; i++) {
                if (password[i] == password[i + 1] && password[i + 1] == password[i + 2]) cnt++;
            }
            if (cnt >= 2) return true;
            return false;
        }
        if (sum == 1) {
            if (n >= 10) return true;
            int cnt = 0;
            for (int i = 0; i < n - 2; i++) {
                if (password[i] == password[i + 1] && password[i + 1] == password[i + 2]) cnt++;
            }
            if (cnt >= 3) return true;
            return false;
        }
        return false;
    }
};