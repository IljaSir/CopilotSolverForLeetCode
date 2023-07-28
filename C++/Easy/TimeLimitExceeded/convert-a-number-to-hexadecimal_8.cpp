class Solution {
public:
    string toHex(int num) {
        
        if(num == 0) return "0";
        string hex = "";
        string hexchar = "0123456789abcdef";
        while(num != 0){
            hex = hexchar[num & 0xf] + hex;
            num >>= 4;
        }
        return hex;
    }
};