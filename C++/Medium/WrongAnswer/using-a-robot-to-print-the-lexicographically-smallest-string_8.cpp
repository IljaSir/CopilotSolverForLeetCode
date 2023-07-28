class Solution {
public:
    string robotWithString(string s) {
        
        string ans = "";
        while (s.size() > 0) {
            if (s.size() == 1) {
                ans += s[0];
                s = "";
            } else if (s[0] < s[s.size() - 1]) {
                ans += s[0];
                s = s.substr(1);
            } else if (s[0] > s[s.size() - 1]) {
                ans += s[s.size() - 1];
                s = s.substr(0, s.size() - 1);
            } else {
                int i = 1;
                while (i < s.size() && s[0] == s[i]) {
                    i++;
                }
                if (i == s.size()) {
                    ans += s[0];
                    s = s.substr(1);
                } else if (s[i] > s[0]) {
                    ans += s[s.size() - 1];
                    s = s.substr(0, s.size() - 1);
                } else {
                    ans += s[0];
                    s = s.substr(1);
                }
            }
        }
        return ans;
    }
};