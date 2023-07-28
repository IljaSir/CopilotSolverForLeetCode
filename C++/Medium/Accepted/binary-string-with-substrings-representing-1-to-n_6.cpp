class Solution {
public:
    bool queryString(string s, int n) {
        
        for(int i = 1; i <= n; i++) {
            string tmp = "";
            int num = i;
            while(num > 0) {
                tmp = (num % 2 == 0 ? "0" : "1") + tmp;
                num /= 2;
            }
            if(s.find(tmp) == string::npos) {
                return false;
            }
        }
        return true;
    }
};