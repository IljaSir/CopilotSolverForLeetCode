class Solution {
public:
    string reformatNumber(string number) {
        
        string num = "";
        for (char c : number) {
            if (c != ' ' && c != '-') {
                num = num + c;
            }
        }
        string ans = "";
        int len = num.length();
        int i = 0;
        while (i < len) {
            int cnt = 0;
            while (i < len && cnt < 3) {
                ans = ans + num[i];
                i++;
                cnt++;
            }
            if (i < len) {
                ans = ans + '-';
            }
            if (len - i == 4) {
                ans = ans + num[i] + num[i + 1];
                ans = ans + '-';
                ans = ans + num[i + 2] + num[i + 3];
                break;
            }
        }
        return ans;
    }
};