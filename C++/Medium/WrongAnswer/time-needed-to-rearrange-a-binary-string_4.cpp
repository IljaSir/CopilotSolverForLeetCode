class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int zero = 0;
        int one = 0;
        for(char c : s){
            if(c == '0'){
                zero++;
            }else{
                one++;
            }
        }
        return min(zero, one);
    }
};