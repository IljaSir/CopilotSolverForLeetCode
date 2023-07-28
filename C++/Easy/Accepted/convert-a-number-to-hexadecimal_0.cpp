class Solution {
public:
    string toHex(int num) {
        
        if (num == 0) return "0";
        string hex = "0123456789abcdef";
        string res = "";
        while (num != 0) {
            res = hex[num & 15] + res;
            num = (unsigned int)num >> 4;
        }
        return res;
    }
};