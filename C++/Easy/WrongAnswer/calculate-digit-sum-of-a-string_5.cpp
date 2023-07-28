class Solution {
public:
    string digitSum(string s, int k) {
        
        int n = s.length();
        if (n <= k) return s;
        string ans;
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += s[i + j] - '0';
            }
            ans += to_string(sum);
        }
        return ans;
    }
    string getLucky(string s, int k) {
        string ans;
        for (auto c : s) {
            ans += to_string(c - 'a' + 1);
        }
        for (int i = 0; i < k; i++) {
            ans = digitSum(ans, 1);
        }
        return ans;
    }
};