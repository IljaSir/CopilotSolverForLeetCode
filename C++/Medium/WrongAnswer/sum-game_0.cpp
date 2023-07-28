class Solution {
public:
    bool sumGame(string num) {
        
        int n = num.size();
        int q = 0;
        int a = 0;
        int b = 0;
        for(int i = 0; i < n/2; i++){
            if(num[i] == '?'){
                q++;
            }else{
                a += num[i] - '0';
            }
        }
        for(int i = n/2; i < n; i++){
            if(num[i] == '?'){
                q++;
            }else{
                b += num[i] - '0';
            }
        }
        if(q == 0){
            return a != b;
        }
        if(q % 2 == 0){
            return a != b;
        }else{
            return a == b;
        }
    }
};