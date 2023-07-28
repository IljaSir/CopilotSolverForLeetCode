class Solution {
    public char findKthBit(int n, int k) {
        
        return find(n, k);
    }
    public char find(int n, int k){
        if(n==1 && k==1){
            return '0';
        }
        int len = (int)Math.pow(2, n)-1;
        int mid = len/2;
        if(k==mid+1){
            return '1';
        }
        if(k<mid+1){
            return find(n-1, k);
        }
        return find(n-1, len-k+1)=='0'?'1':'0';
    }
}