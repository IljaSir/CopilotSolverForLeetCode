class Solution {
public:
    bool checkString(string s) {
        
        bool flag = true;
        int a = 0, b = 0;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == 'a'){
                a++;
            }else{
                b++;
            }
            if(b > a){
                flag = false;
                break;
            }
        }
        return flag;
    }
};