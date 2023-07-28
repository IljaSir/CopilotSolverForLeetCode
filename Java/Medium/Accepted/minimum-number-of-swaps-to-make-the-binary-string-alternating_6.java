class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                count0++;
            }else{
                count1++;
            }
        }
        if(Math.abs(count0 - count1) > 1){
            return -1;
        }
        if(count0 > count1){
            return getSwap(s, '0');
        }else if(count0 < count1){
            return getSwap(s, '1');
        }else{
            return Math.min(getSwap(s, '0'), getSwap(s, '1'));
        }
    }
    public int getSwap(String s, char c){
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != c){
                ans++;
            }
            c = c == '0' ? '1' : '0';
        }
        return ans/2;
    }
}