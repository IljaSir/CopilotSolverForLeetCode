class Solution {
public:
    string reformat(string s) {
        
        string res = "";
        string digit = "";
        string letter = "";
        for(int i = 0; i < s.length(); i++){
            if(s[i] >= '0' && s[i] <= '9'){
                digit += s[i];
            }else{
                letter += s[i];
            }
        }
        if(abs(digit.length() - letter.length()) > 1){
            return res;
        }
        if(digit.length() > letter.length()){
            for(int i = 0; i < digit.length(); i++){
                res += digit[i];
                if(i < letter.length()){
                    res += letter[i];
                }
            }
        }else{
            for(int i = 0; i < letter.length(); i++){
                res += letter[i];
                if(i < digit.length()){
                    res += digit[i];
                }
            }
        }
        return res;
    }
};