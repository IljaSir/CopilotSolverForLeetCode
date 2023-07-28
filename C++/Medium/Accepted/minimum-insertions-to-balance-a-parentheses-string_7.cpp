class Solution {
public:
    int minInsertions(string s) {
        
        int n = s.size();
        int ans = 0;
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                balance++;
            } else {
                if (i < n - 1 && s[i + 1] == ')') {
                    i++;
                } else {
                    ans++;
                }
                if (balance > 0) {
                    balance--;
                } else {
                    ans++;
                }
            }
        }
        return ans + balance * 2;
    }
};