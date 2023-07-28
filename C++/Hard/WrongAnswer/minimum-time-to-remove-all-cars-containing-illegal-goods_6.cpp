class Solution {
public:
    int minimumTime(string s) {
        
        int i = 0, j = s.length() - 1;
        int ans = 0;
        while (i < j) {
            while (i < j && s[i] == '0') i++;
            while (i < j && s[j] == '0') j--;
            if (i < j) {
                ans += 2;
                i++;
                j--;
            }
        }
        if (i == j && s[i] == '1') ans++;
        return ans;
    }
};