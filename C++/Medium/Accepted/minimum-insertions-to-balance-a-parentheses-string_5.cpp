class Solution {
public:
    int minInsertions(string s) {
        
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                left++;
            } else if (s[i] == ')') {
                if (i < s.size() - 1 && s[i + 1] == ')') {
                    i++;
                } else {
                    ans++;
                }
                left--;
                if (left < 0) {
                    ans++;
                    left = 0;
                }
            }
        }
        return ans + left * 2;
    }
};