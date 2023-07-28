class Solution {
public:
    bool sumGame(string num) {
        
        int left = 0, right = 0, q = 0;
        for(int i = 0; i < num.size(); i++){
            if(num[i] != '?'){
                if(i < num.size()/2) left += num[i] - '0';
                else right += num[i] - '0';
            }else{
                q++;
            }
        }
        if(q % 2 != 0) return true;
        if(left == right) return false;
        if(left > right){
            if((left - right) % 9 == 0) return false;
            return true;
        }else{
            if((right - left) % 9 == 0) return false;
            return true;
        }
    }
};