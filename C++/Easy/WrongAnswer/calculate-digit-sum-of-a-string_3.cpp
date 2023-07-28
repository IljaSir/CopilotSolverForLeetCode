class Solution {
public:
    string digitSum(string s, int k) {
        
        string ans = "";
        int n = s.size();
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j < i + k && j < n; ++j) {
                sum += s[j] - '0';
            }
            ans += to_string(sum);
        }
        return ans;
    }
    string calculate(string s, int k) {
        string ans = digitSum(s, k);
        while (ans.size() > k) {
            ans = digitSum(ans, k);
        }
        return ans;
    }
    string truncate(string s, int k) {
        if (s.size() <= k) return s;
        return s.substr(0, k);
    }
    string removeLeadingZero(string s) {
        int n = s.size();
        int i = 0;
        while (i < n && s[i] == '0') {
            ++i;
        }
        return s.substr(i);
    }
    string removeTrailingZero(string s) {
        int n = s.size();
        int i = n - 1;
        while (i >= 0 && s[i] == '0') {
            --i;
        }
        return s.substr(0, i + 1);
    }
    string removeZero(string s) {
        string ans = "";
        int n = s.size();
        bool found = false;
        for (int i = 0; i < n; ++i) {
            if (s[i] != '0') {
                found = true;
            }
            if (found) {
                ans += s[i];
            }
        }
        return ans;
    }
    string removeZero2(string s) {
        return removeLeadingZero(removeTrailingZero(s));
    }
    string removeZero3(string s) {
        int n = s.size();
        int i = 0;
        while (i < n && s[i] == '0') {
            ++i;
        }
        int j = n - 1;
        while (j >= 0 && s[j] == '0') {
            --j;
        }
        return s.substr(i, j - i + 1);
    }
};