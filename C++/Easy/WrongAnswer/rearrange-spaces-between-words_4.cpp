class Solution {
public:
    string reorderSpaces(string text) {
        
        int space = 0;
        int word = 0;
        string s = "";
        for (int i = 0; i < text.length(); i++) {
            if (text[i] == ' ') {
                space++;
            } else {
                if (i == 0 || text[i - 1] == ' ') {
                    word++;
                }
                s += text[i];
            }
        }
        if (word == 1) {
            return s + string(space, ' ');
        }
        int avg = space / (word - 1);
        int remain = space % (word - 1);
        string ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans += s[i];
            if (s[i] == ' ') {
                ans += string(avg, ' ');
            }
        }
        ans += string(remain, ' ');
        return ans;
    }
};