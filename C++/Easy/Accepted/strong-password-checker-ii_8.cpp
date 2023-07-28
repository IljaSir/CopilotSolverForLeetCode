class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.length();
        if(n < 8) return false;
        bool hasLower = false;
        bool hasUpper = false;
        bool hasDigit = false;
        bool hasSpecial = false;
        for(auto c : password){
            if(islower(c)) hasLower = true;
            else if(isupper(c)) hasUpper = true;
            else if(isdigit(c)) hasDigit = true;
            else if(c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') hasSpecial = true;
        }
        if(!hasLower || !hasUpper || !hasDigit || !hasSpecial) return false;
        int same = 0;
        for(int i = 0; i < n; i++){
            if(i > 0 && password[i] == password[i - 1]){
                same++;
            }else{
                if(same >= 2){
                    if(same % 3 == 0) same = 0;
                    else if(same % 3 == 1) same = 1;
                    else same = 2;
                }
            }
        }
        if(same >= 2){
            if(same % 3 == 0) same = 0;
            else if(same % 3 == 1) same = 1;
            else same = 2;
        }
        return same == 0;
    }
};