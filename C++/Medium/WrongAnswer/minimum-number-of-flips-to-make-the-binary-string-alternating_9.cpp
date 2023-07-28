class Solution {
public:
    int minFlips(string s) {
        
        int n=s.size(),ans=0;
        s+=s;
        int zero=0,one=0;
        for(int i=0;i<n;i++){
            if(s[i]=='0'){
                zero++;
            }else{
                one++;
            }
        }
        ans=min(zero,one);
        for(int i=n;i<2*n;i++){
            if(s[i]=='0'){
                zero++;
            }else{
                one++;
            }
            if(s[i-n]=='0'){
                zero--;
            }else{
                one--;
            }
            ans=min(ans,min(zero,one));
        }
        return ans;
    }
};