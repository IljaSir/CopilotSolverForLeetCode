class Solution {
public:
    string reformatNumber(string number) {
        
        string res = "";
        for (char c : number) {
            if (isdigit(c)) {
                res += c;
            }
        }
        string ans = "";
        int i = 0;
        while (i < res.size()) {
            if (res.size() - i == 4) {
                ans += res.substr(i, 2) + "-" + res.substr(i + 2, 2);
                break;
            } else if (res.size() - i == 2) {
                ans += res.substr(i, 2);
                break;
            } else if (res.size() - i == 3) {
                ans += res.substr(i, 3);
                break;
            } else {
                ans += res.substr(i, 3) + "-";
                i += 3;
            }
        }
        return ans;
    }
};