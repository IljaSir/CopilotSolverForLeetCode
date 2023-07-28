class Solution {
public:
    bool digitCount(string num) {
        
        int n = num.size();
        for(int i = 0; i < n; i++){
            int x = num[i] - '0';
            if(x == 0){
                if(num[i] != '0') return false;
            }
            else {
                int count = 0;
                for(int j = 0; j < n; j++){
                    if(num[j] == num[i]) count++;
                }
                if(count != x) return false;
            }
        }
        return true;
    }
    bool isStrobogrammatic(string num) {
        int n = num.size();
        if(n == 1){
            if(num[0] == '0' || num[0] == '1' || num[0] == '8') return true;
            else return false;
        }
        if(n == 2){
            if(num[0] == '6' && num[1] == '9') return true;
            else if(num[0] == '9' && num[1] == '6') return true;
            else return false;
        }
        if(n == 3){
            if(num[0] == '8' && num[1] == '1' && num[2] == '8') return true;
            else return false;
        }
        if(n == 4){
            if(num[0] == '1' && num[1] == '8' && num[2] == '8' && num[3] == '1') return true;
            else return false;
        }
        if(n == 5){
            if(num[0] == '6' && num[1] == '8' && num[2] == '1' && num[3] == '8' && num[4] == '6') return true;
            else return false;
        }
        if(n == 6){
            if(num[0] == '1' && num[1] == '8' && num[2] == '8' && num[3] == '1' && num[4] == '8' && num[5] == '8') return true;
            else return false;
        }
        if(n == 7){
            if(num[0] == '8' && num[1] == '1' && num[2] == '8
    }
};