class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                count++;
            }
        }
        if (count == 0) {
            return (long long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        if (count % 3 != 0) {
            return 0;
        }
        int k = count / 3;
        int i = 0;
        while (i < n && k > 0) {
            if (s[i] == '1') {
                k--;
            }
            i++;
        }
        int j = n - 1;
        while (j >= 0 && k > 0) {
            if (s[j] == '1') {
                k--;
            }
            j--;
        }
        int left = 0;
        int right = 0;
        for (int x = i; x < n && s[x] == '0'; x++) {
            left++;
        }
        for (int x = j; x >= 0 && s[x] == '0'; x--) {
            right++;
        }
        return (long long)(left + 1) * (right + 1) % 1000000007;
    }
};