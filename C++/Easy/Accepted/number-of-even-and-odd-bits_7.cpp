class Solution {
public:
    vector<int> evenOddBit(int n) {
        
        int even=0,odd=0;
        int i=0;
        while(n){
            if(i%2==0){
                if(n&1==1){
                    even++;
                }
            }
            else{
                if(n&1==1){
                    odd++;
                }
            }
            i++;
            n=n>>1;
        }
        return {even,odd};
    }
};