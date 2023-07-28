class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        int res=0;
        int a=1,b=1;
        while(b<=k){
            int c=a+b;
            a=b;
            b=c;
        }
        while(k>0){
            if(k>=a){
                k-=a;
                res++;
            }
            int c=a-b;
            a=b;
            b=c;
        }
        return res;
    }
};