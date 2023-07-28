class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int a = s[0] - 'A';
        int b = s[1] - '0';
        int c = s[3] - 'A';
        int d = s[4] - '0';
        vector<string> res;
        for(int i = a; i <= c; i++) {
            for(int j = b; j <= d; j++) {
                string tmp = "";
                tmp += i + 'A';
                tmp += j + '0';
                res.push_back(tmp);
            }
        }
        return res;
    }
};