class Solution {
public:
    string largestPalindromic(string num) {
        
        string res = "";
        int n = num.size();
        vector<int> cnt(10, 0);
        for (int i = 0; i < n; i++) {
            cnt[num[i] - '0']++;
        }
        for (int i = 9; i >= 1; i--) {
            if (cnt[i] > 0) {
                res += (i + '0');
                cnt[i]--;
                break;
            }
        }
        for (int i = 0; i <= 9; i++) {
            while (cnt[i] > 0) {
                res = (i + '0') + res + (i + '0');
                cnt[i] -= 2;
            }
        }
        return res;
    }
};