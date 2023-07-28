class Solution {
public:
    int maxPower(string s) {
        
        int max = 0;
        int count = 1;
        for(int i = 1; i < s.size(); i++){
            if(s[i] == s[i-1]){
                count++;
            }else{
                if(count > max){
                    max = count;
                }
                count = 1;
            }
        }
        if(count > max){
            max = count;
        }
        return max;
    }
};