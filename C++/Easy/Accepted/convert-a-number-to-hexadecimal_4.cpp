class Solution {
public:
    string toHex(int num) {
        
        if(num == 0)
            return "0";
        string res;
        while(num && res.size() < 8) {
            int digit = num & 0xf;
            if(digit < 10)
                res += '0' + digit;
            else
                res += 'a' + digit - 10;
            num >>= 4;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};