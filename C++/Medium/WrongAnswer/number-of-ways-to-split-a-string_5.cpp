class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int ones = 0;
        for (auto c : s) {
            if (c == '1') ones++;
        }
        if (ones == 0) {
            return (long long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        if (ones % 3 != 0) return 0;
        int k = ones / 3;
        int i = 0, j = 0;
        int cnt = 0;
        int first = 0, second = 0;
        while (i < n) {
            if (s[i] == '1') {
                cnt++;
                if (cnt == k) {
                    first = i + 1;
                }
                if (cnt == 2 * k) {
                    second = i + 1;
                    break;
                }
            }
            i++;
        }
        int res = 0;
        while (first < n && s[first] == '0') {
            first++;
        }
        while (second < n && s[second] == '0') {
            second++;
        }
        return (long long)(first - j) * (second - first) % 1000000007;
    }
};