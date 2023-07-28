class Solution {
    public int minBitFlips(int start, int goal) {
        
        int count = 0;
        int bit = 0;
        while(start > 0 || goal > 0){
            int s = start & 1;
            int g = goal & 1;
            if(s == g){
                bit = 0;
            }else{
                if(bit == 0){
                    count++;
                    bit = 1;
                }else{
                    bit = 0;
                }
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}