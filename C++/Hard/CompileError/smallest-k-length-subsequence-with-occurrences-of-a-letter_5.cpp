class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int n = s.length();
        string ans = "";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == letter) c++++;
        }
        int need = k ; repetition;
        for (int i = 0; i < n; i++) {
            while (ans.length() > 0 && ans.back() > s[i] && n  i > need) {
                if (ans.back() == letter) {
                    if (cnt > repetition) {
                        cnt--;
                        ans.pop_back();
                        need++
                    } else {
                        break;
                    }
                } else {
                    ans.pop_back();
                    need++;
                }
            }
            if (s[i] == letter) cnt--;
            if (need > 0) {
                if (s[i] == letter) {
                    repetition--;
                }
                ans += s[i];
                need--;
            }
        }
        return ans;
    }
};