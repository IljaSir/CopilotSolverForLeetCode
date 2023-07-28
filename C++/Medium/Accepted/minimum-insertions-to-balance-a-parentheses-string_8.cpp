class Solution {
public:
    int minInsertions(string s) {
        
        int ans = 0;
        int n = s.size();
        int l = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                ++l;
            } else {
                if (i + 1 < n && s[i + 1] == ')') {
                    ++i;
                } else {
                    ++ans;
                }
                if (l > 0) {
                    --l;
                } else {
                    ++ans;
                }
            }
        }
        ans += l * 2;
        return ans;
    }
};