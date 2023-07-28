class Solution {
public:
    int minInsertions(string s) {
        
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                left++;
            } else {
                if (i < s.length() - 1 && s[i + 1] == ')') {
                    i++;
                } else {
                    ans++;
                }
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        ans += left * 2;
        return ans;
    }
};