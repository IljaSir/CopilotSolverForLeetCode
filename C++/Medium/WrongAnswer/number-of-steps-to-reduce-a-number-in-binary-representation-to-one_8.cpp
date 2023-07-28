class Solution {
public:
    int numSteps(string s) {
        
        int count = 0;
        int n = s.size();
        int carry = 0;
        for(int i=n-1;i>=1;i--){
            if(s[i]=='1'){
                if(carry==0){
                    count++;
                    carry = 1;
                }
                count++;
            }
            else{
                if(carry==1){
                    count++;
                }
            }
        }
        return count+carry;
    }
};