class Solution {
    public int minimumNumbers(int num, int k) {
        
        if(k==0){
            if(num==0)return 0;
            return -1;
        }
        int ans = 0;
        while(num>0){
            ans++;
            num-=k;
        }
        if(num<0)return -1;
        return ans;
    }
}