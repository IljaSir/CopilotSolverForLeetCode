class Solution {
public:
    string makeFancyString(string s) {
        
        string ans = "";
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s[j] == s[i]) j++;
            int count = j - i;
            if (count >= 3) {
                ans += s[i];
                ans += s[i];
            } else {
                while (i < j) {
                    ans += s[i];
                    i++;
                }
            }
            i = j;
        }
        return ans;
    }
};