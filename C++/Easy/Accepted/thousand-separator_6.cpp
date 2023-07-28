class Solution {
public:
    string thousandSeparator(int n) {
        
        if (n==0) return "0";
        string res;
        int cnt=0;
        while (n>0) {
            res = to_string(n%10) + res;
            n/=10;
            cnt++;
            if (cnt==3 && n>0) {
                res = "." + res;
                cnt=0;
            }
        }
        return res;
    }
};