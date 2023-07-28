class Solution {
public:
    string largestPalindromic(string num) {
        
        string res = "";
        int n = num.size();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && num[j] == '0') j++;
            if (j == n) {
                res = num.substr(0, i) + "9" + num.substr(i);
                break;
            }
            if (j > i) {
                res = num.substr(0, i) + num[j] + num.substr(i, j - i - 1) + num[i] + num.substr(j + 1);
                break;
            }
        }
        return res;
    }
};