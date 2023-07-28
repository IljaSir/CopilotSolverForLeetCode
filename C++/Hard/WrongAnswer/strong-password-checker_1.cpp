class Solution {
public:
    int strongPasswordChecker(string password) {
        
        int n = password.size();
        int add = max(6 - n, 0), del = max(n - 20, 0);
        int lower = 1, upper = 1, digit = 1;
        for (char c : password) {
            if (isdigit(c)) digit = 0;
            else if (islower(c)) lower = 0;
            else if (isupper(c)) upper = 0;
        }
        int missing = (lower + upper + digit);
        if (n < 6) {
            return max(missing, add);
        } else {
            int change = 0;
            vector<int> v;
            for (int i = 0, j = 0; i < n; i = j) {
                while (j < n && password[i] == password[j]) j++;
                if (j - i >= 3) {
                    v.push_back(j - i);
                    change += j - i - 2;
                }
            }
            if (n <= 20) {
                return max(missing, change);
            } else {
                int need_del = n - 20;
                change -= min(need_del, del);
                for (int k = 1; k < 3; k++) {
                    for (int i = 0; i < v.size() && need_del > 0; i++) {
                        if (v[i] < 3 || v[i] % 3 != (k - 1)) continue;
                        v[i] -= min(need_del, k);
                        need_del -= k;
                    }
                }
                change -= need_del / 3;
                return n - 20 + max(missing, change);
            }
        }
    }
};