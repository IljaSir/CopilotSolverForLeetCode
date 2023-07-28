class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int a = s[0] - '0';
        int b = s[0] - '0';
        int c = s[0] - '0';
        int d = s[0] - '0';
        for (int i = 1; i < n; ++i) {
            int x = s[i] - '0';
            a = max(a, x);
            b = min(b, x);
            if (x != a) {
                c = x;
            }
            if (x != b) {
                d = x;
            }
        }
        int ans = 0;
        if (a != b) {
            ans = a * pow(10, n - 1) + num % (int)pow(10, n - 1);
            ans -= b * pow(10, n - 1) + num % (int)pow(10, n - 1);
        }
        int ans1 = 0;
        if (c != d) {
            ans1 = c * pow(10, n - 1) + num % (int)pow(10, n - 1);
            ans1 -= d * pow(10, n - 1) + num % (int)pow(10, n - 1);
        }
        return max(ans, ans1);
    }
};