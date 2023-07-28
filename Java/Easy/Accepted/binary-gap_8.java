class Solution {
    public int binaryGap(int n) {
        
        int max = 0;
        int count = 0;
        boolean started = false;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            if(last == 1){
                if(started){
                    max = Math.max(max, count);
                }
                started = true;
                count = 1;
            }else{
                if(started){
                    count++;
                }
            }
        }
        return max;
    }
}