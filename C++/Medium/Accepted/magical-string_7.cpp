class Solution {
public:
    int magicalString(int n) {
        
        if(n <= 0) return 0;
        if(n <= 3) return 1;
        string s = "122";
        int i = 2, j = 3;
        while(j < n){
            if(s[i] == '1'){
                if(s.back() == '1'){
                    s += "2";
                }else{
                    s += "1";
                }
                j++;
            }else{
                if(s.back() == '1'){
                    s += "22";
                }else{
                    s += "11";
                }
                j += 2;
            }
            i++;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '1') ans++;
        }
        return ans;
    }
};