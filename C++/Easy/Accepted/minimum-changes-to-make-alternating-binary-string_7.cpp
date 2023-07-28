class Solution {
public:
    int minOperations(string s) {
        
        int cnt0=0;
        int cnt1=0;
        for(int i=0;i<s.size();i++){
            if(i%2==0){
                if(s[i]=='0'){
                    cnt0++;
                }
                else{
                    cnt1++;
                }
            }
            else{
                if(s[i]=='1'){
                    cnt0++;
                }
                else{
                    cnt1++;
                }
            }
        }
        return min(cnt0,cnt1);
    }
};