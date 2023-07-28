class Solution {
public:
    string toHex(int num) {
        
        if(num == 0) return "0";
        string str = "0123456789abcdef";
        string res = "";
        while(num != 0){
            res = str[num & 0xf] + res;
            num >>= 4;
        }
        return res;
    }
};