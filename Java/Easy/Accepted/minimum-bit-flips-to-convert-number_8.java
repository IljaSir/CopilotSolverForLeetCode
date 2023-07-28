class Solution {
    public int minBitFlips(int start, int goal) {
        
        int len = 32;
        int ans = 0;
        for(int i = 0; i < len; i++){
            int s = start & 1;
            int g = goal & 1;
            if(s != g){
                ans++;
                start = start ^ 1;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return ans;
    }
}