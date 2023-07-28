class Solution {
public:
    string reformatNumber(string number) {
        
        string res;
        for (auto c : number) {
            if (c != ' ' && c != '-') {
                res.push_back(c);
            }
        }
        int n = res.size();
        string ans;
        for (int i = 0; i < n; i += 3) {
            if (n - i == 4) {
                ans += res.substr(i, 2);
                ans += '-';
                ans += res.substr(i + 2, 2);
                break;
            } else {
                ans += res.substr(i, 3);
                if (i + 3 < n) {
                    ans += '-';
                }
            }
        }
        return ans;
    }
};