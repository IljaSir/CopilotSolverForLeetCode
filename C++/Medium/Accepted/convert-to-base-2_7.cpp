class Solution {
public:
    string baseNeg2(int n) {
        
        if(n==0) return "0";
        string ans="";
        while(n!=0){
            ans=to_string(n&1)+ans;
            n=-(n>>1);
        }
        return ans;
    }
};