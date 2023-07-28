class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        string str = s + s;
        string str1 = "";
        string str2 = "";
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                str1 += "0";
                str2 += "1";
            }
            else {
                str1 += "1";
                str2 += "0";
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; ++i) {
            if (str[i] != str1[i]) {
                ans1++;
            }
            if (str[i] != str2[i]) {
                ans2++;
            }
        }
        int ans = min(ans1, ans2);
        for (int i = n; i < 2 * n; ++i) {
            if (str[i] != str1[i - n]) {
                ans1++;
            }
            if (str[i] != str2[i - n]) {
                ans2++;
            }
            if (str[i - n] != str1[i - n]) {
                ans1--;
            }
            if (str[i - n] != str2[i - n]) {
                ans2--;
            }
            ans = min(ans, min(ans1, ans2));
        }
        return ans;
    }
};