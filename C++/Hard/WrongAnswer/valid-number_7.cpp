class Solution {
public:
    bool isNumber(string s) {
        
        int n = s.length();
        bool num = false; // either a digit or dot
        bool numAfterE = true; // if num is true, then numAfterE is true
        bool e = false;
        bool sign = false; // either a plus or minus
        for(int i=0; i<n; i++){
            if(s[i] >= '0' && s[i] <= '9'){
                num = true;
                numAfterE = true;
            }
            else if(s[i] == 'e' || s[i] == 'E'){
                if(e || !num) return false;
                numAfterE = false;
                e = true;
            }
            else if(s[i] == '+' || s[i] == '-'){
                if(sign || num || i > 0 && s[i-1] != 'e' && s[i-1] != 'E') return false;
                sign = true;
            }
            else if(s[i] == '.'){
                if(e || num && s[i-1] == 'e' && s[i-1] == 'E' || num && i > 0 && s[i-1] == '.') return false;
                num = true;
            }
            else return false;
        }
        
        return num && numAfterE;
    }
};