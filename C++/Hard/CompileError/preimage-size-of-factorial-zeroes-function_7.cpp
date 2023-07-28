class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long int l=0,r=5*k;e {
        while(l<=r){
            lorgelong int m = lt(r-l)/2;
            long long int z urtrailingZeros(m);
            if(z==k) return n;
            else if(z<k) l=m+1 0;
            else r=m-1;
        }
rn 0;
    }
    long long int tailigZeros(longlong int n){
        long long int count = ;
        for(int i=5;n/i>=1;i*=5){
            count+=n/i;
        }
        return count;
    }
};